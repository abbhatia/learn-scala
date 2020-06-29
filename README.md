**Table of Contents**

- [FSiS Part 2 - Applicative type class](#fsis-part-2---applicative-type-class)
- [Why applicatives](#why-applicatives)
- [Start from](#start-from)

# FSiS Part 1 - Type Constructors, Functors, and Kind Projector

https://youtu.be/Dsd4pc99FSY?t=1031


# FSiS Part 2 - Applicative type class

https://www.youtube.com/watch?v=tD_EyIKqqCk&t=1426s
https://github.com/typelevel/simulacrum

# Why applicatives
https://dzone.com/articles/applicatives-in-scala

Functors are restricted to lift only functions of arity -1 into computational context. So then we have the problem of how to lift a function of arity -2 into computational context.

The combination of these two makes it feasible to partially apply arity- n function to all of its arguments inside a computational context.

Applicatives allows us to apply functions of arbitrary arity (>=1) to its arguments inside a computational context, and as functors provide for the exact functions of arity-1, Applicatives can be thought as generalized functors.

# Start from 

https://youtu.be/tD_EyIKqqCk?t=2553

Read speficis of how monads/applicatives