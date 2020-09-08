package com.self.algorithm.sort;

import java.util.Arrays;

/**
 * 描述:
 * 自己编写的选择排序法
 *
 * @author tongaijie-9697
 * @create 2020-09-07 10:31
 */
public class MySelectSort {

    public static void main(String[] args) {
        int[] arr = {3,1,5,2,7,4,6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 第 i 位
            int index = i;
            // 记录第 i 位的数字
            int indexValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // 如果第 i 位之后的第 j 位大于第 i 位
                if (arr[j] < indexValue) {
                    // 重新定义第 i 位，
                    indexValue = arr[j];
                    // 记录最小的数的下标位置
                    index = j;
                }
            }
            // 如果第 i 位和以前不一样，则赋值第 i 位
            if (arr[i] != indexValue) {
                // 交换最小位置的值
                arr[index] = arr[i];
                arr[i] = indexValue;
            }
        }
        return arr;
    }
}
