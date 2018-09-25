package com.haibo.future.web.interview.concurrency.SyncDemo;

public class Sync3 {
    public void t1() throws InterruptedException {
        synchronized (Sync3.class){
        System.out.println("------begin-----");
        Thread.sleep(1000);
        System.out.println("------end-----");
        }
    }

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sync3().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sync3().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sync3().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
