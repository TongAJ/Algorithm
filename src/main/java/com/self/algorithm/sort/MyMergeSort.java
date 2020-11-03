package com.self.algorithm.sort;

import java.util.Arrays;

/**
 * 自己编写归并排序算法
 *
 * @author tong-aj
 * create 2020-09-10
 */
public class MyMergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 4, 1, 8, 6, 9, 5};
        System.out.println(Arrays.toString(divideAndMerge(arr, 0, arr.length - 1, new int[arr.length])));
    }

    /**
     * param arr
     * param left
     * param right
     * param temp
     * return
     */
    public static int[] divideAndMerge(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divideAndMerge(arr, left, mid, temp);
            divideAndMerge(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
        return arr;
    }

    /**
     * param arr
     * param left
     * param mid
     * param right
     * param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int indexL = left;
        int indexR = mid + 1;
        int t = 0;

        while (indexL <= mid && indexR <= right) {
            if (arr[indexL] > arr[indexR]) {
                temp[t] = arr[indexR];
                indexR++;
            } else {
                temp[t] = arr[indexL];
                indexL++;
            }
            t++;
        }

        while (indexL <= mid) {
            temp[t] = arr[indexL];
            indexL++;
            t++;
        }
        while (indexR <= right) {
            temp[t] = arr[indexR];
            indexR++;
            t++;
        }

        t = 0;
        while (left <= right) {
            arr[left] = temp[t];
            left++;
            t++;
        }
    }
}
