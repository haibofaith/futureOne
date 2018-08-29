package com.haibo.future.web.interview.dataStructure;

import java.util.Arrays;

public class Stack<E> {
    private Object[] data = null;
    private int maxSize = 0;
    private int top = -1;

    public Stack() {
        this(10);
    }

    public Stack(int maxSize) {
        if (maxSize >= 0) {
            this.maxSize = maxSize;
            data = new Object[maxSize];
            top = -1;
        } else {
            throw new RuntimeException("不能小于0");
        }
    }

    public E pop(){
        if (top != -1){
            E e = (E) data[top];
            data[top] = null;
            top--;
            return e;
        }else {
            throw new RuntimeException("栈已空");
        }
    }

    public boolean push(E e){
        if (top >= maxSize - 1){
            //最大
            throw new RuntimeException("栈已满");
        }else {
            data[++top] = e;
            return true;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
