package com.skytravelr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnonymousTest {

    @Test
    public void serveFood_shouldCallTheRegularImplementation() {
        final Food food = new Food();
        assertEquals("food", Anonymous.serveFood(food));
    }

    @Test
    public void serveFood_shouldCallTheAnonymousSubclassImplementation() {
        // create an instance of an anonymous subclass of Food
        final Food food = new Food() {

            @Override
            public String serve() {
                return "new food";
            }
        };
        assertEquals("new food", Anonymous.serveFood(food));
    }

    @Test
    public void serveFood_shouldCallTheClassImplementation() {
        final Eatable food = new Food();
        assertEquals("food", Anonymous.serveFood(food));
    }

    @Test
    public void serveFood_shouldCallTheAnonymousInterfaceImplementation() {
        // create an instance of an anonymous implementation of interface Eatable
        final Eatable food = new Eatable() {
            @Override
            public String serve() {
                return "some food";
            }
        };
        assertEquals("some food", Anonymous.serveFood(food));
    }
}
