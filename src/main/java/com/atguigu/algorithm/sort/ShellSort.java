package com.atguigu.algorithm.sort;

import java.util.Arrays;

/**
 * 描述: 希尔排序算法（交换算法）
 *
 * @author tong-aj
 * create 2020-09-07 15:32
 */
public class ShellSort implements MySort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 9, 4, 6, 10, 8, 7};
        System.out.println(Arrays.toString(new ShellSort().sort(arr)));
    }

    /**
     * param arr
     * return
     */
    public int[] sortExchange(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }


    /**
     * 基于位移的 希尔算法
     *
     * param arr
     * return
     */
    @Override
    public int[] sort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                // 说明需要位移
                if (arr[i] < arr[i - gap]) {
                    // 记录有序列表下标
                    int index = i - gap;
                    // 记录待插入的值
                    temp = arr[i];
                    while (index >= 0 && arr[index] > temp) {
                        arr[index + gap] = arr[index];
                        index -= gap;
                    }
                    arr[index + gap] = temp;
                }
            }
        }
        return arr;
    }
}
