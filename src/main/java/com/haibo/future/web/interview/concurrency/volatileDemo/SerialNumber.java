package com.haibo.future.web.interview.concurrency.volatileDemo;

/**
 * 安全性失败：可复现
 */
public class SerialNumber {
    private static volatile int nextSerialNumber = 0;

    public static int getNextSerialNumber() {
        //此操作不是同步的 nextSerialNumber先取值运算，然后赋值 。中间有个时间差。会有问题
        return nextSerialNumber++;
    }

    //测试代码如下 ，会有并发问题产生
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
