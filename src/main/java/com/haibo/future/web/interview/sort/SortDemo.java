package com.haibo.future.web.interview.sort;

import com.haibo.future.web.interview.sort.bubbleSort.BubbleSort;
import com.haibo.future.web.interview.sort.bucketSort.BucketSort;
import com.haibo.future.web.interview.sort.quiksort.QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//
public class SortDemo {

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
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        array = QuickSort.quickSort2(array,0,arrays.size()-1);
        System.out.println("");
        System.out.println("------after quick sort-----");
        for (int ay:array){
            System.out.print(" "+ay);
        }
        int[] afterBubbleArray = BubbleSort.bubbleSort(array2);
        System.out.println("");
        System.out.println("------after bubble sort-----");
        for (int ay:afterBubbleArray){
            System.out.print(" "+ay);
        }
        int[] afterBucketArray = BucketSort.bucketSort(array3);
        System.out.println("");
        System.out.println("------after bucketsort-----");
        for (int i=0;i<afterBucketArray.length;i++){
            if (afterBucketArray[i]>0){
                for (int j=0;j<afterBucketArray[i];j++){
                    System.out.print(" "+i);
                }
            }
        }
    }
}
