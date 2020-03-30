package com.skytravelr;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnonymousComparator {

    static List<String> sort(final List<String> list, final Comparator<String> comparator) {
        // we know that it's bad practice to modify the original list (given as parameter),
        // so we create a copy of it first
        final List<String> copiedList = copy(list);
        // we had to make a copy of the list because we're going to use Collections.sort()
        // and this method modifies in-place the list it receives as parameter (bad practice)
        Collections.sort(copiedList, comparator);
        // now the list referenced by copiedList is sorted; it has been modified in-place
        // by Collections.sort()
        return copiedList;
    }

    private static List<String> copy(final List<String> ss) {
        // we create a new String instance for each element in the original list
        // and then we collect these new strings and create a new list
        return ss.stream().map(s -> new String(s)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // this is the list we want to sort using different comparators
        final List<String> someStrings = Arrays.asList("ghi", "abc", "def");

        System.out.println("Case 1\n------");
        final Comparator<String> naturalOrderComparator = new NaturalOrderComparator();
        // we sort using a reference to an instance of NaturalOrderComparator
        final List<String> someStringsSorted = sort(someStrings, naturalOrderComparator);
        // we see that our sort implementation didn't change the original list
        // which is the desired behavior
        System.out.println("Before: " + someStrings);
        // the returned list is sorted
        System.out.println("After: " + someStringsSorted);

        System.out.println("Case 2\n------");
        // next we create a variable which references an instance of
        // an anonymous implementation of the Comparator<String> interface
        final Comparator<String> reversedNaturalOrderComparator = new Comparator<String>() {

            // again, this implementation is useless as we already have
            // Comparator.naturalOrder().reversed()
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        };
        // we sort again, this time using a new comparator
        final List<String> someStringsSortedInReverse = sort(someStrings, reversedNaturalOrderComparator);
        System.out.println("Before: " + someStrings);
        // the returned list is sorted
        System.out.println("After: " + someStringsSortedInReverse);

        System.out.println("Case 3\n------");
        // we sort again, this time using an anonymous implementation of a comparator
        // created where we expect a method parameter
        final List<String> someStringsSortedAgain = sort(someStrings, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println("Before: " + someStrings);
        // the returned list is sorted
        System.out.println("After: " + someStringsSortedAgain);

        System.out.println("Case 4\n------");
        // we sort again, this time we replace the anonymous implementation of the comparator
        // with a lambda expression
        final List<String> someStringsSortedAgainWithLambda = sort(someStrings, (a, b) -> a.compareTo(b));
        System.out.println("Before: " + someStrings);
        // the returned list is sorted
        System.out.println("After: " + someStringsSortedAgainWithLambda);

        System.out.println("Case 5\n------");
        // we sort again, this time we replace the lambda expression
        // with a method reference
        final List<String> someStringsSortedAgainWithMethodReference = sort(someStrings, String::compareTo);
        System.out.println("Before: " + someStrings);
        // the returned list is sorted
        System.out.println("After: " + someStringsSortedAgainWithMethodReference);

        System.out.println("Case 6\n------");
        // we sort again, this time we replace the method reference
        // with a provided implementation of a natural order comparator
        final List<String> someStringsSortedAgainWithAnotherMethodReference = sort(someStrings, Comparator.naturalOrder());
        System.out.println("Before: " + someStrings);
        // the returned list is sorted
        System.out.println("After: " + someStringsSortedAgainWithMethodReference);
    }
}

/**
 * This Comparator implementation is useless
 * because we already have this functionality implemented
 * in java.util.Comparator.naturalOrder()
 */
class NaturalOrderComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}
