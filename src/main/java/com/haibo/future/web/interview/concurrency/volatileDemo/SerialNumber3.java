package com.haibo.future.web.interview.concurrency.volatileDemo;

import java.util.concurrent.atomic.AtomicLong;

public class SerialNumber3 {
    private static final AtomicLong nextSerialNumber = new AtomicLong();

    public static long getNextSerialNumber() {
        return nextSerialNumber.getAndIncrement();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thread1 + " + getNextSerialNumber());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thread2 + " + getNextSerialNumber());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
