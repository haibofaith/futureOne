package com.haibo.future.web.interview.string;

import java.util.HashMap;

public class StringTest {
    public static void main(String[] args){
        String a = "hello2";
        String b = "hello";
        String c = b+2;
        System.out.println("-------a==c-------"+(a==c));
        String d = "hello2";
        final String e = "hello";
        String f = e+2;
        System.out.println("-------d==f-------"+(d==f));
        String g = "hello2";
        final String h = getH();
        String i = h+2;
        System.out.println("-------g==i-------"+(g==i));

        MyClass myClass = new MyClass();
        MyClass myClass1 = new MyClass();
        System.out.println("i---------"+myClass.i);
        System.out.println("i---------"+myClass1.i);
        System.out.println("j---------"+myClass.j);
        System.out.println("j---------"+myClass1.j);
    }

    public static String getH(){
        return "hello";
    }
}
