package com.haibo.future.web.interview.concurrency.waitAndNotify;

import java.util.Vector;

public class Producer implements Runnable{
    private final Vector shareQueue;
    private final int size;

    public Producer(Vector shareQueue,int size) {
        this.shareQueue = shareQueue;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        while (shareQueue.size()==size){
            System.out.println("------队列已满-----队列等待中-----");
            synchronized (shareQueue){
                shareQueue.wait();
            }
        }
        synchronized (shareQueue){
            System.out.println("------队列生产中-----"+i);
            shareQueue.add(i);
            //是consumer取消等待
            shareQueue.notifyAll();
        }
    }


}
