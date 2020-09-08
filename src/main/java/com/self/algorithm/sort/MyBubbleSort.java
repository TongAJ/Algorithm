package com.self.algorithm.sort;

import java.util.Arrays;

/**
 * 描述:
 * 自己编写冒泡算法
 *
 * @author tongaijie-9697
 * @create 2020-09-07 10:24
 */
public class MyBubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,1,5,2,7,4,6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 对给定的数组进行冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            boolean flag = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        return arr;
    }
}
