# Moving Average from Data Stream

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
