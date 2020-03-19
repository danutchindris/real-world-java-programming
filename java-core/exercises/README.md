# Exercises

## Table of Contents

  * [Exercises](#exercises)
    * [Exercise 1 (Arrays, Strings)](#exercise-1-arrays-strings)
    * [Exercise 2 (Numere perfecte)](#exercise-2-numere-perfecte)  
    * [Exercise 3 (Moving Average from Data Stream)](#exercise-3-moving-average-from-data-stream)
    * [Exercise 4 (Palindrome Permutation)](#exercise-4-palindrome-permutation)

## Exercise 1 (Arrays, Strings)

Se da un `String` format din litere mici 'a' - 'z'.
Sa se determine caracterele unice din `String` si frecventa lor.
De exemplu, pentru input-ul "abracadabra", output-ul va fi un `String` "a5b2r2c1d1".
Caracterele vor fi prezente in output in ordinea primei lor aparitii in input, deci nu in ordine alfabetica.

Cu alte cuvinte, trebuie sa determinam ce litere exista in `String`-ul de intrare si sa numaram de cate ori apare fiecare.
Pentru simplitate, consideram ca input-ul contine doar litere mici.
Output-ul va fi un `String` care contine literele gasite, grupate cu numarul lor de aparitii.
Un alt exemplu:
- input: "paralelipiped"
- output: "p3a2r1l2e2i2d1" 

Constrangeri: putem folosi doar *array*-uri (nu `List` si implementarile acestuia; nici un alt tip de `Collection`).

Incercam sa gasim un algoritm cat mai optim ca timp de executie si spatiu de memorie folosit.

Sugestii:
- stiind ca input-ul poate contine doar litere mici, putem sa ne folosim de asta pentru a optimiza algoritmul
- 'a' are codul ASCII 97, 'b' - 98 s.a.m.d.
    - ex:
    
          char c = 'a';
          int cx = c; // cx are valoarea 97; se face cast implicit la int
          System.out.println(cx); // afiseaza pe ecran 97
    

- 'a' este un `char`, dar `char`-urile nu sunt nimic altceva decat `int`-uri in fond; poate ne putem folosi de asta
- putem accesa caracterul de la pozitia *x* dintr-un `String` folosind metoda `String.charAt(x)` - nu e neaparat sa folosim asta, dar poate ajuta

## Exercise 2 (Numere perfecte)

Un numar *n* se numeste *numar perfect* daca este egal cu suma divizorilor sai naturali
mai mici ca *n*. De exemplu, 6 = 1 + 2 + 3 este *perfect*.

Determinati toate *numerele perfecte* mai mici sau egale cu *k* (dat la intrare)
si afisati-le.

## Exercise 3 (Moving Average from Data Stream)

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,

    MovingAverage m = new MovingAverage(3);
    m.next(1) = 1
    m.next(10) = (1 + 10) / 2
    m.next(3) = (1 + 10 + 3) / 3
    m.next(5) = (10 + 3 + 5) / 3

Taken from [Wikipedia](https://en.wikipedia.org/wiki/Moving_average):

>In statistics, a *moving average* (*rolling average* or *running average*) is a calculation to analyze data points
>by creating a series of averages of different subsets of the full data set.
>
>Given a series of numbers and a fixed subset size, the first element of the moving average is obtained
>by taking the average of the initial fixed subset of the number series. Then the subset is modified
>by "shifting forward"; that is, excluding the first number of the series and including the next value in the subset.

## Exercise 4 (Palindrome Permutation)

Given a string, determine if a permutation of the string could form a palindrome.

For example,

`"code"` -> False  
`"aab"` -> True  
`"carerac"` -> True
