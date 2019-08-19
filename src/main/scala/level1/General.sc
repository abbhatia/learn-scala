// 1. Hiding a val with another val. This is not actually reassigment, its start of a new scope.
// In worksheet or scala program, it anyways doesn't allow you to do that
val x = 1

println(x)

{
  val x = 2
  println(x)
}

println(x)

//val x = 3 // not allowed in worksheet/scala program


// 2. Even if you can reassign var, you can change the type

var y = 2
y = 3

//y = "three" // not allowed

// 3. Types are required when you created methods.
// Return types can be inferred but param types cannot

def add(x: Int, y: Int) = x + y

//4. 'if' is an expression rather than statements (which favor immutability).
// its like a ternary operator  in java where you don't mutate the variables

val isInteger  = true

val i = if(isInteger) 1 else 2

// you can choose to ignore returned value and then its like other languages

var m = 0

if(isInteger) m =  1 else m =  2

print(m)

// But functional style is not ignoring returned values and avoiding side-effects
//Scala places a greater emphasis on expressions(that return values) rather than
//statements that do not

// if 'if' has more than one statement, last statement is the return value
// scala has a return keyword but rarely there's need to use it

//5. Scala also opts for expressions over statements in exception handling
// finally is always run but will not return a value(used for side effects)
// Uncaught exceptions are automatically re-thrown
// you may also choose to re-throw a caught exception

val divided = try{
  10/0
} catch {
  case ae: ArithmeticException => 0
} finally {
  println("this always runs but does not affect the result")
  42
}

//6. Loops
//Scala has only one true looping construct: while (and the associated do..while)

//while is a statement, and has no useful return type of its own

//while is non-functional and is often replaced by foreach or map functions
//over collections, or by for and for..yield blocks

//while is still used for various reasons, including performance

//while must have a side-effect to do anything useful

//In Scala, everything has a return type, there is no void

//Unit is provided as a return type for statements, it has one instance: ()

//7. String interpolation

val num = 4
println(s"The value of $num is ${num  * num }")


//8. Running a script
//To run it as a script, use scala squares.sc

//To load it, start scala or sbt console, then :load squares.sc. note we use .sc since otherwise sbt will try and compile it