package com.atguigu.algorithm.sort;

import com.atguigu.algorithm.uitl.Util;

import java.util.Arrays;

/**
 * 描述:
 * 插入排序法
 *
 * @author tongaijie-9697
 * @create 2020-09-04 9:49
 */
public class InsertSort implements MySort{

    public static void main(String[] args) {

        int[] result = Util.testTimeCost(100000, new InsertSort());
        System.out.println(Arrays.toString(result));
    }

    /**
     * 插入排序法
     *
     * @param arr
     * @return
     */

    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的值
            int minValue = arr[i];
            // 定义 待插入数的下标 前一个值得下标位置
            int minIndex = i -1;

            // 给待插入的值寻找合适的位置
            // minIndex >= 0 防止下标越界
            // 如果待插入的值 小于 有序数组中的值
            while (minIndex >= 0 && arr[minIndex] > minValue){
                // 将有序的值后移一位
                arr[minIndex+1] = arr[minIndex];
                // 再和有序数组的前一位进行比较
                minIndex --;
            }
            // 如果位置有变动
            if(minIndex+1 != i){
                // while循环过后，待插入的值找到了自己在有序数组的下标位置minIndex+1；
                arr[minIndex+1] = minValue;
            }
        }
        return arr;
    }
}
