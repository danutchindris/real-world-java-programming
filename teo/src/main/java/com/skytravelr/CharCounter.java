package com.skytravelr;

import java.util.stream.Collectors;

/**
 * @author Teo
 * @since 12.03.2020
 */
public class CharCounter {

    public static void main(String[] args) {
        String input = "elephant";
        /*for (char c = 'a'; c <= 'z'; c++){
            char finalC = c;
            System.out.println(someString.chars().filter(ch -> ch == finalC).count());
        }*/

        String distinct = input.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .distinct()
                .collect(Collectors.joining(""));

        for (int i = 0; i < distinct.length(); i++) {
            char litera = distinct.charAt(i);
            System.out.print(litera + "" + input.chars().filter(ch -> ch == litera).count());
        }
    }
}
