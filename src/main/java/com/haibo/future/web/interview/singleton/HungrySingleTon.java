package com.haibo.future.web.interview.singleton;

public class HungrySingleTon {
    private static final HungrySingleTon hungrySingleTon = new HungrySingleTon();

    private HungrySingleTon() {
    }

    public static HungrySingleTon getInstance() {
        return hungrySingleTon;
    }
}
