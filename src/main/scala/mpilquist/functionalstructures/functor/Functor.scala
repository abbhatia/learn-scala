package mpilquist.functionalstructures.functor

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]

}

trait FunctorLaws {
  def identity[F[_], A](fa: F[A])(implicit F: Functor[F]) = F.map(fa)(a => a) == fa

  def composition[F[_], A, B, C](fa: F[A], f: A => B, g: B => C)(implicit F: Functor[F]) =
    F.map(F.map(fa)(f))(g) == F.map(fa)(f andThen  g)
}

object Functor {
  implicit  val listFunctor = new Functor[List] {
    override def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }
  implicit  val optionFunctor = new Functor[Option] {
    override def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }
}