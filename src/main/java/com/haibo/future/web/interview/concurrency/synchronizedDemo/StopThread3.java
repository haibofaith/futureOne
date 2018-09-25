package com.haibo.future.web.interview.concurrency.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * volatile
 */
public class StopThread3 {
    private static volatile boolean stopRequested;
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
