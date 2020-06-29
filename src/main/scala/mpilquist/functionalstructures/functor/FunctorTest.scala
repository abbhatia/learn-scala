package mpilquist.functionalstructures.functor

object FunctorTest {
  def main(args: Array[String]): Unit = {
    val value = implicitly[Functor[List]]
    val ints = value.map(List(1, 2, 3))(_ + 1)
    println(ints)
    val maybeInt = implicitly[Functor[Option]].map(Option(1))(_ + 1)
    println(maybeInt)

  }
}
