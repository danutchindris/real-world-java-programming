package com.skytravelr;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnonymousComparatorTest {

    private final List<String> list = Arrays.asList("ghi", "abc", "def");

    @Test
    public void sort_shouldReturnNewListSortedByNaturalOrder() {
        assertEquals(Arrays.asList("abc", "def", "ghi"), AnonymousComparator.sort(list, new NaturalOrderComparator()));
    }

    @Test
    public void sort_shouldReturnNewListSortedByReversedNaturalOrder() {
        final Comparator<String> reverseNaturalOrderComparator = new Comparator<String>() {

            // this implementation is useless as we already have
            // Comparator.naturalOrder().reversed()
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        };
        assertEquals(Arrays.asList("ghi", "def", "abc"), AnonymousComparator.sort(list, reverseNaturalOrderComparator));
    }

    @Test
    public void sort_shouldReturnNewListSortedUsingAnonymousComparatorImplementation() {
        assertEquals(Arrays.asList("abc", "def", "ghi"), AnonymousComparator.sort(list, new Comparator<String>() {

            // this implementation is useless as we already have
            // Comparator.naturalOrder()
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        }));
    }

    @Test
    public void sort_shouldReturnNewListSortedUsingLambdaExpression() {
        assertEquals(Arrays.asList("abc", "def", "ghi"), AnonymousComparator.sort(list, (a, b) -> a.compareTo(b)));
    }

    @Test
    public void sort_shouldReturnNewListSortedUsingMethodReference() {
        assertEquals(Arrays.asList("abc", "def", "ghi"), AnonymousComparator.sort(list, String::compareTo));
    }

    @Test
    public void sort_shouldReturnNewListSortedUsingProvidedComparator() {
        assertEquals(Arrays.asList("abc", "def", "ghi"), AnonymousComparator.sort(list, Comparator.naturalOrder()));
    }

    @Test
    public void sort_shouldReturnNewListSortedInReverseOrderUsingProvidedComparator() {
        assertEquals(Arrays.asList("ghi", "def", "abc"), AnonymousComparator.sort(list, Comparator.reverseOrder()));
    }
}
