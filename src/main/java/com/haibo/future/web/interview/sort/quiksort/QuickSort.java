package com.haibo.future.web.interview.sort.quiksort;

//自己写的，更具aha算法
public class QuickSort {
    public static int[] quickSort2(int[] arrays, int low, int high) {
        if (low>high){
            return arrays;
        }
        //1、左边第一个开始
        int temp = arrays[low];
        int left = low;
        int right = high;
        //2.1、从右到左，找到第一个比temp小的数的位置
        //2.2、从左到右，找到第一个比temp大的数的位置
        //2.3、交换位置
        while (left!=right){
            while (temp<=arrays[right]&&left<right){
                right--;
            }
            while (temp>=arrays[left]&&left<right){
                left++;
            }
            if (left<right){
                swap(arrays,left,right);
                log(arrays);
            }
        }
        //第一个和当前位置的交换
        arrays[low] = arrays[left];
        arrays[left] = temp;
        log(arrays);
        //左侧
        quickSort2(arrays,low,left-1);
        //右侧
        quickSort2(arrays,left+1,high);
        return arrays;
    }

    private static void swap(int[] arrays, int left, int right){
        int temp = arrays[left];
        arrays[left] = arrays[right];
        arrays[right]=temp;
    }

    private static void log(int[] arrays){
        System.out.println("");
        for (int ay :arrays){
            System.out.print(" "+ay);
        }
    }
}
