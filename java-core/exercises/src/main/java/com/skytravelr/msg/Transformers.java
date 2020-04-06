package com.skytravelr.msg;

public class Transformers {

    // transforms a Message into a String
    // by taking only the text out of the Message object
    // this implementation could be replaced
    // by a lambda expression, like this:
    // static Transformer<String> toString = m -> m.text
    static Transformer<String> toString = new Transformer<String>() {

        @Override
        public String apply(Message message) {
            return message.text;
        }
    };

    // TODO: please uncomment the grayed out lines in the unit tests
    //  present in com.skytravelr.msg.TransformersTest
    //  make sure to run the tests so that you validate your solution

    // TODO: please implement the following transformers
    //  first using anonymous classes and then using lambda expressions

    // the sender and receiver of an SMS are some constant values chosen by us
    // static Transformer<SMS> toSMS = ...

    // the sender of a Tweet is a constant value chosen by us
    // static Transformer<Tweet> toTweet = ...
}
