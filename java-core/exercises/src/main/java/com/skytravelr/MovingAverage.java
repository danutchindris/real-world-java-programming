package com.skytravelr;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private final int size;
    private final Queue<Integer> q = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public int next(int n) {
        if (q.size() == size) {
            q.remove();
        }
        q.add(n);
        return q.stream().reduce(0, Integer::sum).intValue() / q.size();
    }
}
