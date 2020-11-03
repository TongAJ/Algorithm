package com.atguigu.algorithm.sort;

import com.atguigu.algorithm.uitl.Util;

import java.util.Arrays;

/**
 * 描述:
 * 冒泡算法
 *
 * @author tong-aj
 * @create 2020-09-03 11:21
 */
public class BubbleSort implements MySort{

    public static void main(String[] args) {
        int[] result = Util.testTimeCost(100000, new BubbleSort());
        System.out.println(Arrays.toString(result));
    }



    /**
     * 根据输入的数组，进行冒泡排序，然后输出
     *
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        // 当出现逆序时的临时变量，方便交换
        int temp ;
        // 判断档次排序时是否出现交换，如果都没有交换，则提前完成冒泡排序
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                // 如果都没有交换
                break;
            }else {
                // 将标志位复原
                flag = false;
            }
        }
        return arr;
    }
}
