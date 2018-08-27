package com.haibo.future.web.sort.quiksort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//查找自网络
public class QuickSort {
    /**
     *
     * @param array
     * @param low 从第几位开始
     * @param high 到第几位结束
     */
    private static int[] quickSort(int array[],int low,int high){
        if(low<high){
            int p=partition(array, low, high);
            quickSort(array,low,p-1);
            quickSort(array, p+1, high);
        }
        return array;
    }

    /**
     *
     * @param a
     * @param low
     * @param hi
     * @return i 返回当前哨兵位置
     */
    public static int partition(int[] a,int low, int hi){
        int i,j,privot;
        privot=a[hi];
        i=low;
        //遍历最低位到最高位
        for(j=low;j<=hi-1;j++){
            //将比哨兵小的都放在哨兵左边
            if(a[j]<privot){
                swap(a, i, j);
                i++;
            }
        }
        //将哨兵
        swap(a,i,hi);
        return i;
    }
    public static void swap(int[] a,int lo,int hi){
        int s=a[lo];
        a[lo]=a[hi];
        a[hi]=s;
    }

    public static void main(String[] args){
        List<Integer> arrays = new ArrayList<>();
        System.out.println("------before sort-----");
        for (int i=0;i<10;i++){
            arrays.add(new Random().nextInt(100));
            System.out.print(" "+arrays.get(i));
        }
        int[] array = new int[arrays.size()];
        for (int i=0;i<arrays.size();i++){
            array[i] = arrays.get(i);
        }
        array = QuickSort2.quickSort2(array,0,arrays.size()-1);
        System.out.println("");
        System.out.println("------after sort-----");
        for (int ay:array){
            System.out.print(" "+ay);
        }
    }
}
