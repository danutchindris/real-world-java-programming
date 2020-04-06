package com.skytravelr.msg;

import java.time.Instant;
import java.util.Objects;

public class Message {

    public final String text;
    public final Instant timestamp;

    public Message(String text) {
        this.text = text;
        this.timestamp = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
