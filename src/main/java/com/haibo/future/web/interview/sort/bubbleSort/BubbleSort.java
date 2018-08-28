package com.haibo.future.web.interview.sort.bubbleSort;

public class BubbleSort {
    public static int[] bubbleSort(int[] array){
        //核心思想：两两比较，较大者上浮。每次只能确定一个数，需要确定N*N次
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length;j++){
                if (j+1<array.length){
                if (array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
                }
            }
        }
        return array;
    }

    private static void swap(int[] array,int a,int b){
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
    }
}
