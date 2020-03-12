package com.skytravelr;

/**
 * @author Teo
 * @since 12.03.2020
 */
public class CharCounter {

    public static void main(String[] args) {
        String someString = "elephant";
        for (char c = 'a'; c <= 'z'; c++){
            char finalC = c;
            System.out.println(someString.chars().filter(ch -> ch == finalC).count());
        }
    }
}
