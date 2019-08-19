This is my attempt to document everything I am going through for refreshing my concepts in scala. There are 3 sections(and hence 3 packages) to it.

1. problems - the problems I'd do by myself for refreshing
2. utilities - the utilities I mostly encounter to be used frequently
3. level 1/2/3 - Different levels of what I think are required ( 1 being the lowest)

# Quick Hacks

1. In scala shell, use :paste mode to evaluate many commands at once

```scala
val x = 1

println(x)

{
  val x = 2
  println(x)
}

println(x)
```

# Problems

## Problem 1
1. Create a Scala script file called timestable.sc in your working directory (make a directory if you need to)
2. Write two while loops from 1 to 5, one inside the other. Call one loop variable x and the other y
3. println a message in the inner loop that says s"$x times $y is ${x * y}
4. Remember to increment both x and y in their respective loops
5. Print out lines if the result of the multiplication contains either a '4' or a '6' digit in the number produced.
6. Either run your script using scala timestable.sc or sbt console then :load timestable.sc to check that it works. You should get 6 lines of output.
