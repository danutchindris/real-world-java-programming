package com.skytravelr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PerfectNumberTest {

    @Test
    public void shouldReturnTrue() {
        assertTrue("Should have returned true because 6 is perfect", PerfectNumber.isPerfect(6));
    }

    @Test
    public void shouldReturnFalse() {
        assertEquals("The number is not perfect", false, PerfectNumber.isPerfect(10));
    }
}
