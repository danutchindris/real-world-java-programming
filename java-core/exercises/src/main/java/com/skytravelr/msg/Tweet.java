package com.skytravelr.msg;

import java.util.Objects;
import java.util.UUID;

public class Tweet extends Message {

    public UUID id;
    public String sender;

    public Tweet(String text, String sender) {
        // we make sure that the Tweet text is maximum 160 characters long
        super(text != null ? text.substring(0, Math.min(text.length(), 140)) : "");
        this.id = UUID.randomUUID();
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tweet tweet = (Tweet) o;
        return text.equals(tweet.text) && sender.equals(tweet.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sender);
    }
}
