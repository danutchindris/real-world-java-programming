# Functions

## Motivation

>Functional programs contain no assignment statements, so variables, once given a value, never change.
>More generally, functional programs contain no side-effects at all. A function call can have no effect
>other than to compute its result. This eliminates a major source of bugs, and also makes the order of execution
>irrelevant — since no side-effect can change an expression’s value, it can be evaluated at any time.
>This relieves the programmer of the burden of prescribing the flow of control. Since expressions can be
>evaluated at any time, one can freely replace variables by their values and vice versa—that is,
>programs are "referentially transparent." This freedom helps make functional programs more tractable mathematically
>than their conventional counterparts.

(John Hughes - "Why Functional Programming Matters")

## The Importance of Functions

Functional programming (FP) is a style of designing and writing programs more and more popular in the recent years.
Although it's difficult to give a clear definition of what functional programming is, we can identify a few common
characteristics of functional programs. One of them is that FP is about programming with functions.

Functions are important because they are the building blocks of programs. Functional programs are built by composing *functions*
that take an argument and return a value. Here we are thinking about functions in the mathematical sense. 

Functional programming is opposed to the imperative programming paradigm. In imperative programming style,
programs are composed of elements that "do" something. That implies that there is an initial state, a transition
and an end state. This process is also known as *state mutation*. On the other hand, functional programs are composed of
elements that "are" something - they don't "do" something. For instance, the addition of 3 and 4 doesn't *make* 7. It *is* 7.

## Bibliography

- Bartosz Milewski - Category Theory for Programmers (2019)
- Pierre-Yves Saumont - Functional Programming in Java (How functional techniques improve your Java programs) (Manning, 2017)
