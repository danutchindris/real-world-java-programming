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

The main consequence is that each time we encounter 3 + 4 we can replace it with 7. In imperative programming, we normally can't do that
because of the mutations happening. Other times, the imperative code does other things besides returning a value, such as
writing to the console or logging to a file, or changing the value of a variable outside the "function". These effects are called
*side effects* because they are not part of the single responsibility the function should have.

A useful program has some kind of effects in the outside world. The user wants to see something displayed on the screen or
listen to a audio file being played. The idea of functional programming is to have these effects (mutations to the outside world)
as late as possible. So the core of the programming is formed only by composing *pure functions*. The interaction with the outside world
won't occur in the middle of a computation, but only when the computation is finished. Side effects will be delayed and applied separately.

The idea of *pure functions* is that a function takes one argument (just one, as we will see later) and gives back a value,
having no side effects. In practice, this is virtually impossible because, to say the least, it takes time for the function
to return the value, and this is also a side effect. Other times, the function might throw an out-of-memory error
or a stack-overflow error, which are also observable side effects. But the idea is to create functions
with no *intentional side effects*. And when we do that we have many benefits that we will discover through our journey.

## Functions Characteristics

### A Definition

A function is a relation between a domain and a co-domain. A function receives an argument and returns a value.
The argument's type is the type of the domain. The returned value has the type of the co-domain.

There is no such thing as a function of several arguments in mathematics: a function is a relation between
a source set and a target set.
We can have the illusion that a function may have several arguments, but the product of two sets is also a set.

e.g. 
    
    f: N x N -> N
    f(x,y) = x + y
    
    (x,y) is a pair (a special case of a tuple)
    but it's essentially just one argument, not two
    
    we can apply the function f to the tuple (3,5):
    
    f((3,5)) = 3 + 5
 

### Common Characteristics of Pure Functions

Pure functions are based on the idea of a mathematical function. When we program in FP style by writing pure functions,
our functions will have the following traits:
- they only return a value and *do* nothing else
- they don't mutate any element of the outside world
- they don't mutate their arguments
- they don't throw exceptions
- they don't log anything, they don't print anything to the console or any other device
- they don't write to file, databases, networks etc.

### Example of an Impure Function

    public class Company {
    
       private String name;
       private Boolean bidded;
       ...
    }
    
    public class Auction {
       
       private Map<Company, Double> bids = new HashMap<>();
       
       public void bid(Company company, Double value) {
          System.out.println("Company " + company.getName() +
             " started the bid process with value " + value);
          Set<Company> participants = bids.keySet();
          if (!participants.contains(company)) {
             bids.put(company, value);
          }
          company.setBidded(true);
          if (value <= 0) {
             throw new IllegalArgumentException("Bidding value should be positive");
          }
       }
    }

### Transforming the Previous Function into a Pure Function

...

### Partial Functions and Total Functions

    public static int div(int a, int b) {
       return a / b;
    }

A relation that isn't defined for all the elements of the domain is called a *partial function*.
In contrast a relation defined for all the elements of the domain is called a *total function*.

Many bugs are a result of using partial functions as if they were total functions.
Turning partial functions into total functions is an important part of functional programming.

#### Examples

Are These Partial or Total Functions? If they are partial functions, how can we turn them into
total functions? 

###### Example 1

    f: N -> N
    f(x)=x-1

###### Example 2

    f: N -> N
    f(x)=x+1

###### Example 3

    String getEquipmentDescription(final Person p) {
       return p.getEquipment().getDescription();
    }

## Referential Transparency

## Function Composition

## Currying

## Bibliography

- Bartosz Milewski - Category Theory for Programmers (2019)
- Pierre-Yves Saumont - Functional Programming in Java (How functional techniques improve your Java programs) (Manning, 2017)
