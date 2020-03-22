package com.skytravelr;

import java.util.stream.IntStream;

public class PerfectNumber {

    // (x, y) -> x + y
    // is equivalent with
    // Integer::sum

    // filter - selection operation; elements are NOT transformed
    // the resulting stream will only contain the elements which pass the condition of the predicate

    // predicate - operation which takes a value and returns a boolean
    // it decides whether the passed in value meets a certain condition or not

    // reduce - operation which combines the elements of the stream together, based on a rule (e.g. Integer::sum)
    public static boolean isPerfect(final int n) {
        return IntStream
                .rangeClosed(1, n / 2)
                .filter(i -> n % i == 0)
                .reduce(0, Integer::sum) == n;
    }
}
