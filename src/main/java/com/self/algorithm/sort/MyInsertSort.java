package com.self.algorithm.sort;

import java.util.Arrays;

/**
 * 描述:
 * 自己编写插入算法
 *
 * @author tong-aj
 * create 2020-09-07 11:09
 */
public class MyInsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 7, 4, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 使用无序数组的第1位 与有序数组中的倒排进行比对
     *
     * param arr
     * return
     */
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 带比较的有序队列下标位置
            int index = i - 1;
            // 带插入的无序队列中的值
            int value = arr[i];
            // 如果下标没有越界，并且无需队列的第一位比有序队列的倒排第i位小
            while (index >= 0 && arr[index] > value) {
                // 赋值无需队列
                arr[index + 1] = arr[index];
                index--;
            }
            if (arr[index + 1] != value) {
                arr[index + 1] = value;
            }
        }

        return arr;
    }
}
