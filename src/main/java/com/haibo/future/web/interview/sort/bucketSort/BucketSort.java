package com.haibo.future.web.interview.sort.bucketSort;

/**
 * 桶排序
 */
public class BucketSort {
    public static int[] bucketSort(int[] array) {
        //1-100中的数据排序
        int[] bucketArray = new int[100];
        for (int i = 0; i < bucketArray.length; i++) {
            bucketArray[i] = 0;
        }
        //读入到bucketArray中
        //每一个读入的数，对应数值+1
        for (int j = 0; j < array.length; j++) {
            //100个桶就绪
            for (int i = 0; i < bucketArray.length; i++) {
                if (i == array[j]) {
                    bucketArray[i]++;
                }
            }
        }
        return bucketArray;
    }
}
