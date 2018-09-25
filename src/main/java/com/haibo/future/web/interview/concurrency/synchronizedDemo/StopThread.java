package com.haibo.future.web.interview.concurrency.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * 活性失败：无法复现
 * 然而，我当前虚拟机可以1秒后停下
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested){
                    i++;
                    System.out.println(i+"-----");
                }
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

}
