package com.skytravelr.threads;

public class ThreadsExample {

    public static void myRun() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Runnable my = ThreadsExample::myRun;

        Thread t0 = new Thread(ThreadsExample::myRun, "MyThread-0");
        t0.start();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }, "MyThread-1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }, "MyThread-2");
        t2.start();
    }
}
