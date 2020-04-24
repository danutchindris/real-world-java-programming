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
        // in Scala: def apply(message: Message): String = ???
    };

    // the sender and receiver of an SMS are some constant values chosen by us
    static Transformer<SMS> toSMS = new Transformer<SMS>() {

        @Override
        public SMS apply(Message message) {
            return new SMS(message.text, "Me", "You");
        }
    };

    // the sender of a Tweet is a constant value chosen by us
    static Transformer<Tweet> toTweet = new Transformer<Tweet>() {

        @Override
        public Tweet apply(Message message) {
            return new Tweet(message.text, "Me");
        }
    };

    static Transformer<String> toStringLambda = msg -> msg.text;

    static Transformer<SMS> toSMSLambda = msg -> new SMS(msg.text, "Me", "You");

    static Transformer<Tweet> toTweetLambda = msg -> new Tweet(msg.text, "Me");
}
