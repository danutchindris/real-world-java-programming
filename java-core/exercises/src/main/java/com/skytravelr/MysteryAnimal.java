package com.skytravelr;

/**
 * What is bear + 1?
 */
public class MysteryAnimal {

    private static final String BEAR = "🐻"; // "\ud83d\udc3b"

    public static void main(String[] args) {
        int bearCodePoint = BEAR.codePointAt(BEAR.offsetByCodePoints(0, 0));
        int animal = bearCodePoint + 1;
        char[] animalChar = {Character.highSurrogate(animal), Character.lowSurrogate(animal)};

        System.out.println(String.valueOf(animalChar));
    }
}
