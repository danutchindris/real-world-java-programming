# Project for Presenting Java Core Features

## Java 8

### Bibliography

- Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft - Modern Java in Action (Manning, 2019)
- Raoul-Gabriel Urma, Richard Warburton - Real-World Software Development (O'Reilly, 2019)
- Raoul-Gabriel Urma - Introducing Java 8 (O'Reilly, 2015)
- Richard Warburton - Java 8 Lambdas (O'Reilly, 2014)
- Joshua Bloch - Effective Java, 3rd Edition (Addison-Wesley, 2018) (Chapter 7, Lambdas and Streams)
- Venkat Subramaniam - Functional Programming in Java - Harnessing the Power of Java 8 Lambda Expressions (The Pragmatic Programmers, 2014)

### The `Optional<T>` Type

###### Why do we need it?

Tony Hoare, one of the most well-known names in computer science stated in 2009:

>I call it my billion-dollar mistake. It was the invention of the null reference in 1965...
>I couldn't resist the temptation to put in a null reference, simply because it was so easy
>to implement.

Accidentally accessing a property or calling a method on a `null` reference causes the runtime to throw a `NullPointerException`.
In my experience, this is the most common cause for bugs in Java applications.

When working with objects in Java we are in one of two situations:
- we rely on the business logic and we assume that our variable has a value, hoping that it doesn't reference a `null`
- or we constantly check for `null` using the if-else statement:

       if (city != null) {
         System.out.println(city.getPostalCode());
       }

The first strategy is a bad idea because it's not safe to assume that things will always go as we hope. We have to program defensively and prepare for the case when the object isn't there.
The second approach works, but it has two flaws:
- it's easy to forget (or to be too lazy) to check for `null`
- the code gets easily cluttered with `null` checks; it becomes difficult to read and boring to write. In addition, more lines of code means more expensive maintenance.

The `Optional<T>` type was added to Java 8 to allow developers to safely express the idea that an object might or might not be present.
As a consequence, if we consistently use the technique which we describe here, we are sure that our code won't throw `NullPointerException`s at runtime.

###### How do we use it?

`Optional<T>` acts like a single-value container. It either contains a value or it's empty.
