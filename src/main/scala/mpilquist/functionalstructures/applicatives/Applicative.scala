package mpilquist.functionalstructures.applicatives

trait Applicative[F[_]] {
  def pure[A](a:A): F[A]

  def apply[A, B](fa: F[A])(ff: F[A => B]): F[B]

  //read again -- tricky
  def apply2[A, B, Z](fa: F[A], fb: F[B])(ff: F[(A, B) => Z]): F[Z] = {
    //second part of apply needed F(A=>Z)
    // and we have F[(A, B) => Z]
    // so we write a map function
    // map(ff: F[(A, B) => Z]) => F[A=>Z]
    // so we need second part of map function
    // (A,B) => Z  =>  A => Z
    //
    apply(fa)(apply(fb)(map(ff)(f => b => a => f(a, b))))
//    apply(fa)(apply(fb)(map(ff)(f => b => a => f(a, b))))
  }

  def map[A, B](fa: F[A])(f: A => B): F[B] =
    apply(fa)(pure(f))

  def map2[A, B, Z](fa: F[A], fb: F[B])(f: (A, B) => Z): F[Z] =
    apply(fa)((map(fb)(b => f(_,b))))

  def map3[A, B, C, Z](fa: F[A], fb: F[B], fc: F[C])(f: (A, B, C) => Z): F[Z] =
    apply(fa)(map2(fb, fc)((b,c) => a => f(a, b, c)))

  def map4[A, B, C, D, Z](fa: F[A], fb: F[B], fc: F[C], fd: F[D])(f: (A, B, C, D) => Z): F[Z] =
//    apply(fa)(map3(fb, fc, fd)((b,c,d) => a => f(a, b, c,d)))
  //can be done in map-conquer twice with map2
  //tuple2 fa fb, and then fc fd
    // can use this approach for everything going foreard
    //map5 is map2 + map3
  map2(tuple2(fa, fb), tuple2(fc, fd)){case((a, b), (c, d)) => f(a, b, c, d)}


  def tuple2[A, B](fa: F[A], fb: F[B]): F[(A, B)] =
    map2(fa, fb)((a, b) => (a, b))

  def tuple3[A, B, C](fa: F[A], fb: F[B], fc: F[C]): F[(A, B, C)] =
    map3(fa, fb, fc)((a, b, c) => (a, b, c))

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
