package com.haibo.future.web.interview.dataStructure;

import java.util.Random;

public class StructureDemo {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>(13);
        for (int i = 0;i<10;i++){
            stack.push(new Random().nextInt(100));
        }
        System.out.println("-----"+stack.toString()+"-----");
        stack.pop();
        stack.push(1000);
        System.out.println("-----"+stack.toString()+"-----");
        for (int i=0;i<5;i++){
            stack.pop();
        }
        System.out.println("-----"+stack.toString()+"-----");
    }
}
