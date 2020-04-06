package com.skytravelr.msg;

import java.util.Objects;

public class SMS extends Message {

    public String sender;
    public String receiver;

    public SMS(String text, String sender, String receiver) {
        // we make sure that the SMS text is maximum 160 characters long
        super(text != null ? text.substring(0, Math.min(text.length(), 160)) : "");
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SMS sms = (SMS) o;
        return text.equals(sms.text) && sender.equals(sms.sender) && receiver.equals(sms.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sender, receiver);
    }
}
