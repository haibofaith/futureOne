package com.haibo.future.web.interview.concurrency.SyncDemo;

public class Sync2 {
    private static Sync2 sync2 = new Sync2();
    private Sync2(){}
    public static Sync2 getInstance(){
        return sync2;
    }

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
                    Sync2.getInstance().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Sync2.getInstance().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Sync2.getInstance().t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
