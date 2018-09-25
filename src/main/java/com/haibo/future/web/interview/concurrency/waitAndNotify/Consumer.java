package com.haibo.future.web.interview.concurrency.waitAndNotify;

import java.util.Vector;

public class Consumer implements Runnable{
    private final Vector shareQueue;

    public Consumer(Vector shareQueue) {
        this.shareQueue = shareQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("------消费中-----"+consume());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer consume() throws InterruptedException {
        if (shareQueue.isEmpty()){
            System.out.println("------队列已空-----消费等待中-----");
            synchronized (shareQueue){
                shareQueue.wait();
            }
        }
        synchronized (shareQueue){
            shareQueue.notifyAll();
            return (Integer) shareQueue.remove(0);
        }
    }
}
