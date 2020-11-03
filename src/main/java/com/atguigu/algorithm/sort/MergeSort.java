package com.atguigu.algorithm.sort;

import java.util.Arrays;

/**
 * 描述:
 * 归并排序算法
 *
 * @author tong-aj
 * @create 2020-09-09 14:04
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 4, 1, 8, 6, 9, 5};
        System.out.println(Arrays.toString(divideAndMerge(arr, 0, arr.length - 1, new int[arr.length])));
    }

    /**
     * 合并的过程
     *
     * @param arr   源数组
     * @param left  左侧的下标位置
     * @param mid   中间的下标位置
     * @param right 右侧的下标位置
     * @param temp  临时数组
     * @return
     */
    public static void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {
        // 左侧起始下标
        int l = left;
        // 右侧起始下标
        int r = mid + 1;
        // 用于记录temp的数组下标
        int t = 0;

        // 当左侧起始的下标小于等于mid，右侧起始下标小于right
        while (l <= mid && r <= right) {
            // 两个数组进行比较，右侧较小的插入temp，移动右侧下标
            if (arr[l] > arr[r]) {
                // 右侧元素赋值temp数组
                temp[t] = arr[r];
                // temp下标移动
                t++;
                // 右侧数组下标移动
                r++;
            }
            // 两个数组进行比较，左侧较小的插入temp，移动左侧下标
            else {
                // 左侧元素赋值temp数组
                temp[t] = arr[l];
                // temp下标移动
                t++;
                // 左侧数组下标移动
                l++;
            }
        }

        // 将源数组中左侧，有剩余的部分，全部插入到temp数组中
        // 将剩余数组插入temp
        while (l <= mid) {
            temp[t] = arr[l];
            l++;
            t++;
        }
        // 将源数组中右侧，有剩余的部分，全部插入到temp数组中
        // 将剩余数组插入temp
        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }
        t = 0;
        int tempLeft = left;
        // 将temp数组赋值给源数组
        while (tempLeft <= right) {
            // *** 注意，赋值是从源数组的left位开始进行的
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }

    /**
     * 分+合并
     *
     * @param arr
     * @param l
     * @param r
     * @param temp
     * @return
     */
    public static int[] divideAndMerge(int[] arr, int l, int r, int[] temp) {
        if (l < r) {
            int mid = (l + r) / 2;
            divideAndMerge(arr, l, mid, temp);
            divideAndMerge(arr, mid + 1, r, temp);
            mergeSort(arr, l, mid, r, temp);
        }
        return arr;
    }
}
