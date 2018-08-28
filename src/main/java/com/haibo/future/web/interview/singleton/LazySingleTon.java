package com.haibo.future.web.interview.singleton;

public class LazySingleTon {
    private static LazySingleTon lazySingleTon = null;
    private LazySingleTon() {
    }

    //加上同步锁:双重锁定
    public static LazySingleTon getInstance() {
        if (lazySingleTon==null){
            synchronized (LazySingleTon.class){
                if (lazySingleTon==null){
                    lazySingleTon = new LazySingleTon();
                }
            }
        }
        return lazySingleTon;
    }
}
