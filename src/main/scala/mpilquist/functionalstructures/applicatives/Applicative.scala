package mpilquist.functionalstructures.applicatives

trait Applicative[F[_]] {
  def pure[A](a:A): F[A]

  def apply[A, B](fa: F[A])(ff: F[A => B]): F[B]

  def map[A, B](fa: F[A])(f: A => B): F[B] =
    apply(fa)(pure(f))

  def map2[A, B, Z](fa: F[A], fb: F[B])(f: (A, B) => Z): F[Z] =
    apply(fa)((map(fb)(b => f(_,b))))

}

object Applicative {
  implicit val optionApplicative: Applicative[Option] = new Applicative[Option] {
    override def pure[A](a: A): Option[A] = Some(a)

    override def apply[A, B](fa: Option[A])(ff: Option[A => B]): Option[B] = (fa,ff) match {
      case (None, _) => None
      case (Some(_), None) => None
      case (Some(a), Some(f)) => Some(f(a))
    }
  }

  implicit val listApplicative: Applicative[List] = new Applicative[List] {
    override def pure[A](a: A): List[A] = List(a)

    //this doesn't work as zip  takes the least of two
    // for this listApplicative.map(List(1,2,3))(_+3) , it takes the function which has only one elements
    // and so returns List(4)
//    override def apply[A, B](fa: List[A])(ff: List[A => B]): List[B] =
//      (fa zip ff).map { case(a,f) => f(a) }

    override def apply[A, B](fa: List[A])(ff: List[A => B]): List[B] = for {
      a <- fa
      f <- ff
    } yield f(a)
  }
}
