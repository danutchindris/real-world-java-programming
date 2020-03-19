package com.skytravelr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovingAverageTest {

    private static final int WINDOW_SIZE = 3;

    @Test
    public void shouldCalculateForOneElement() {
        final MovingAverage ma = new MovingAverage(WINDOW_SIZE);
        assertEquals("Moving average is not correct", 1, ma.next(1));
    }

    @Test
    public void shouldCalculateForTwoElements() {
        final MovingAverage ma = new MovingAverage(WINDOW_SIZE);
        ma.next(1);
        assertEquals("Moving average is not correct", (1 + 10) / 2, ma.next(10));
    }

    @Test
    public void shouldCalculateForThreeElements() {
        final MovingAverage ma = new MovingAverage(WINDOW_SIZE);
        ma.next(1);
        ma.next(10);
        assertEquals("Moving average is not correct", (1 + 10 + 3) / 3, ma.next(3));
    }

    @Test
    public void shouldCalculateForNextThreeElements() {
        final MovingAverage ma = new MovingAverage(WINDOW_SIZE);
        ma.next(1);
        ma.next(10);
        ma.next(3);
        assertEquals("Moving average is not correct", (10 + 3 + 5) / 3, ma.next(5));
    }
}
