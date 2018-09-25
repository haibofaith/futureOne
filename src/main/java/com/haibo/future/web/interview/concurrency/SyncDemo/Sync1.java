package com.haibo.future.web.interview.concurrency.SyncDemo;

public class Sync1 {
    public synchronized void t1() throws InterruptedException {
        System.out.println("------begin-----");
        Thread.sleep(1000);
        System.out.println("------end-----");
    }

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sync1().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sync1().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sync1().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
