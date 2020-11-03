package com.atguigu.algorithm.sort;

import com.atguigu.algorithm.uitl.Util;

import java.util.Arrays;

/**
 * 描述:
 * 基于桶排序的基数排序
 *
 * @author tong-aj
 * create 2020-09-10 16:51
 */
public class RadixSort implements MySort{

    public static void main(String[] args) {
        int[] result = Util.testTimeCost(100000, new RadixSort());
        System.out.println(Arrays.toString(result));

    }

    @Override
    public int[] sort(int[] arr) {
        // 因为无法确认每一个桶中有多少个数字，所以保证每个桶可以存放源数组中所有的数据
        int[][] radix = new int[10][arr.length];
        // 类似稀疏数组，index表示第index个桶，表示每个桶中有多少数字
        int[] bucketOfElements = new int[radix.length];
        // 获得源数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        // 获取max的长度
        int length = String.valueOf(max).length();
        for (int k = 1; k <= length; k++) {
            // 第k轮 ,判断源数组的每个数的个位数，放入对应下标的桶中
            for (int i = 0; i < arr.length; i++) {
                int pow = (int)Math.pow(10, k);
                int element = (arr[i] * 10 / pow) % 10;
                // 放入桶中
                radix[element][bucketOfElements[element]] = arr[i];
                // 记录桶中数量++
                bucketOfElements[element]++;
            }

            // 依次从桶中取出数字放回源数组中
            // 定义一个辅助下标
            int index = 0;
            for (int i = 0; i < radix.length; i++) {
                // 当桶中有数字才放入源数组
                if(bucketOfElements[i] > 0){
                    for (int j = 0; j < bucketOfElements[i]; j++) {
                        // 放入源数组
                        arr[index] = radix[i][j];
                        // 下标后移
                        index++;
                    }
                    // 每完成一个桶的取出工作，就清除该桶
                    bucketOfElements[i] = 0;
                }
            }
        }
        return arr;
    }
}
