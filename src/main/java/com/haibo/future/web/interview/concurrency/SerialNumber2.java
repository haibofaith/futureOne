package com.haibo.future.web.interview.concurrency;

public class SerialNumber2 {
    private static int nextSerialNumber = 0;

    public static synchronized int getNextSerialNumber() {
        return nextSerialNumber++;
    }

    //测试代码如下 ， 不会有并发问题产生，不会同时读到一个数据
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
