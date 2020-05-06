package com.skytravelr.msg;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformerFunctions {

    static Transformer<String> toStringLambda = msg -> msg.toString();

    static Transformer<String> toStringMethodRef = Message::toString;

    static Transformer<SMS> toSMSLambda = msg -> new SMS(msg.text, "Me", "You");

    static Transformer<Tweet> toTweetLambda = msg -> new Tweet(msg.text, "Me");

    static <T> List<T> mapMessages(List<Message> messages, Transformer<T> transformer) {
        return messages
                .stream()
                .map(transformFunction(transformer))
                .collect(Collectors.toList());
    }

    private static <T> Function<Message, T> transformFunction(Transformer<T> transformer) {

        return new Function<Message, T>() {
            @Override
            public T apply(Message message) {
                return transformer.apply(message);
            }
        };
    }
}
