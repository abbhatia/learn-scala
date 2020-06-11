package mpilquist.functionalstructures.applicatives
import mpilquist.functionalstructures.applicatives.Applicative
import mpilquist.functionalstructures.applicatives.Applicative._

object Test {
  def main(args: Array[String]): Unit = {

    optionApplicative.map(Some(1))(_+3)
    optionApplicative.map(None: Option[Int])(_ + 3)

    val ints = listApplicative.map(List(1, 2, 13))(_ + 3)
//    println(ints)
    val option = optionApplicative.map2(Option(1), Option(2))(_ + _)
//    println(option)

    val ints1 = listApplicative.map2(List(1, 2, 3), List(4, 5, 6))(_ + _)
    println(ints1)


  }
}
