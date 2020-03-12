package com.skytravelr;

/**
 * # Exercise 1 - arrays, Strings
 */
public class Exercise01 {

    public static void main(String[] args) {
        final String input = "paralelipiped";
        final char[] as = find(input);
        print(as);
    }

    public static char[] find(final String input) {
        final char[] as = new char[52];
        byte j = -2;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int idx = findIndex(as, c);
            if (idx != -1) {
                as[idx + 1]++;
            } else {
                j += 2;
                as[j] = c;
                as[j + 1] = 1;
            }
        }
        return as;
    }

    private static int findIndex(char[] xs, char x) {
        for (int i = 0; i < xs.length; i += 2) {
            if (xs[i] == x) {
                return i;
            }
        }
        return -1;
    }

    private static void print(final char[] xs) {
        for (int i = 0; i < 52 && xs[i] != 0; i++) {
            if (i % 2 == 0) {
                System.out.print(xs[i]);
            } else {
                System.out.print((int) xs[i]);
            }
        }
    }
}
