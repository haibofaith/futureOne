package com.haibo.future.web.interview.concurrency.waitAndNotify;

import java.util.Vector;

public class TestDemo {
    public static void main(String[] args){
        Vector<Integer> vector = new Vector<Integer>();

        new Thread(new Producer(vector,5)).start();

        new Thread(new Consumer(vector)).start();
    }
}
