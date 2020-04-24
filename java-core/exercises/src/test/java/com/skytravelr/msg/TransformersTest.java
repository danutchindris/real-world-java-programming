package com.skytravelr.msg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransformersTest {

    @Test
    public void toString_shouldReturnTheStringRepresentationOfTheMessage() {
        Message message = new Message("Some Message");
        String expected = "Some Message";
        String actual = Transformers.toString.apply(message);
        assertEquals(expected, actual);
    }

    @Test
    public void toSMS_shouldReturnTheSmsFromTheMessage() {
        Message message = new Message("Some Message");
        SMS expected = new SMS("Some Message", Constants.SENDER, Constants.RECEIVER);
        SMS actual = Transformers.toSMS.apply(message);
        assertEquals(expected, actual);
    }

    @Test
    public void toTweet_shouldReturnTheTweetFromTheMessage() {
        Message message = new Message("Some Message");
        Tweet expected = new Tweet("Some Message", Constants.SENDER);
        Tweet actual = Transformers.toTweet.apply(message);
        assertEquals(expected, actual);
    }
}
