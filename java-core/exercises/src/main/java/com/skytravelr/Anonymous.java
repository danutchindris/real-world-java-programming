package com.skytravelr;

public class Anonymous {

    static String serveFood(final Eatable food) {
        return food.serve();
    }

    public static void main(String[] args) {
        // create regular instance of Food, nothing special here
        final Food food1 = new Food();
        System.out.println(serveFood(food1));

        // create an instance of an anonymous subclass of Food
        final Food food2 = new Food() {

            @Override
            public String serve() {
                return "new food";
            }
        };
        System.out.println(serveFood(food2));

        // create regular instance of Food and reference it by its supertype Eatable
        final Eatable food3 = new Food();
        System.out.println(serveFood(food3));

        // create an instance of an anonymous implementation of interface Eatable
        // # observation: IntelliJ is clever and warns us that this anonymous implementation
        // # can be replaced by a lambda expression
        final Eatable food4 = new Eatable() {

            @Override
            public String serve() {
                return "some food";
            }
        };
        System.out.println(serveFood(food4));
    }
}

class Food implements Eatable {

    @Override
    public String serve() {
        return "food";
    }
}

interface Eatable {

    String serve();
}
