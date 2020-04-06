package com.skytravelr.msg;

@FunctionalInterface
interface Transformer<T> {

    T apply(Message message);
}
