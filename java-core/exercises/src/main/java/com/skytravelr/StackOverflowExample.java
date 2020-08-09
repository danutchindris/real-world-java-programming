package com.skytravelr;

public class StackOverflowExample {

    public static void main(String[] args) {
        try {
            doStuff();
        } catch (StackOverflowError e) {
            System.out.println("Eroareeee");
        }
    }

    private static int doStuff() {
        return doStuff() + 1;
    }
}
