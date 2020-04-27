package com.skytravelr.msg;

import java.util.function.Consumer;

public class MessageConsumers {

    public static void printMessage(Message msg) {
        System.out.println(msg);
    }

    public static void saveToDatabase(Message msg) {
        // saving data to database
    }

    public static void applyToMessage(Message msg, Consumer<Message> c) {
        c.accept(msg);
    }

    public static void main(String[] args) {
        Message message = new Message("Hello Java");

        applyToMessage(message, m -> printMessage(m));

        // MessageConsumers::printMessage - "method reference"
        // "method reference" - o exprimare concisa a unei expresii lambda

        // echivalenta cu varianta de mai sus, cu expresie lambda
        applyToMessage(message, MessageConsumers::printMessage);

        applyToMessage(message, (Message msg) -> saveToDatabase(msg));

        // echivalenta cu varianta de mai sus, cu expresie lambda
        applyToMessage(message, MessageConsumers::printMessage);
    }
}
