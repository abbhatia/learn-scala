package mpilquist.functionalstructures.applicatives
import mpilquist.functionalstructures.applicatives.Applicative
import mpilquist.functionalstructures.applicatives.Applicative._

object ApplicativeTest {
  def main(args: Array[String]): Unit = {

//    val maybeInt = optionApplicative.map(Some(1))(_ + 3)
//    println(maybeInt)
//    val maybeInt1 = optionApplicative.map(None: Option[Int])(_ + 3)
//    println(maybeInt1)
//
//
//
//    val ints = listApplicative.map(List(1, 2, 13))(_ + 3)
//    println(ints)
//val option = optionApplicative.map2(Option(1), Option("2"))(_.toString + _)
//    println(option)
//    val option8 = optionApplicative.map2(Option(1), Option(2))(_ + _)
//    println(option8)
//
//    val ints1 = listApplicative.map2(List(1, 2, 3), List(4, 5, 6))(_ + _)
//    println(ints1)
//
//    val option1 = optionApplicative.map3(Option(1), Option(2), Option(3))(_ + _ + _)
//    println(option1)
//
    val option2 = optionApplicative.tuple3(Option(1), Option(2), Option(3))
    println(option2)
//
//    //cross product
    val ints2 = listApplicative.tuple2(List(1, 2, 3), List(4, 5, 6))
    println(ints2)
    val option4 = optionApplicative.map4(Option(1), Option(2), Option(3), Option(4))(_ + _ + _ + _)
        println(option4)


  }
}
