package com.atguigu.algorithm.sort;

import com.atguigu.algorithm.uitl.Util;

import java.util.Arrays;

/**
 * 描述:
 * 选择排序
 *
 * @author tong-aj
 * create 2020-09-03 15:33
 */
public class SelectSort implements MySort{

    public static void main(String[] args) {
        int[] result = Util.testTimeCost(100000, new SelectSort());
        System.out.println(Arrays.toString(result));
    }

    /**
     * 选择排序
     * 第i次找数组中最小的数，与第i位进行位置互换
     *
     * param arr
     * return
     */
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 定义第i位为最小的
            int minIndex = i;
            int minValue = arr[i];
            for (int j = 1 + i; j < arr.length; j++) {
                // 遍历判断是否之后的每一位都小于最小值，如果大于
                if (minValue > arr[j]) {
                    // 重新定位最小值和最小值所在下标
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            // 如果遍历完，最小值下标和遍历前一样，不需要数值互换，
            if (minIndex != i) {
                // 反之，则互换位置
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
        return arr;
    }
}
