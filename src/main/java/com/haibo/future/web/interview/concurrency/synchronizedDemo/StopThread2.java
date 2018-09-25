package com.haibo.future.web.interview.concurrency.synchronizedDemo;

import java.util.concurrent.TimeUnit;

public class StopThread2 {
    private static boolean stopRequested;

    public static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    public static synchronized void setStopRequested(boolean stopRequested) {
        StopThread2.stopRequested = stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isStopRequested()){
                    i++;
                    System.out.println(i+"-----");
                }
                System.out.println("end-----");
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        setStopRequested(true);
    }

}
