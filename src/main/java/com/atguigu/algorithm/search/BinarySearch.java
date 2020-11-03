package com.atguigu.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 二分法查找
 *
 * @author tong-aj
 * 2020-09-14 16:56
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,10,10,11};
        List<Integer> search = search(0, arr.length - 1, arr, 10);
        System.out.println(Arrays.toString(search.toArray()));
    }

    /**
     * 二分法查找
     *
     * param left      左侧index
     * param right     右侧index
     * param arr       源数组
     * param findValue 被查找数
     * return 匹配下标结果列表
     */
    public static List<Integer> search(int left, int right, int[] arr, int findValue) {
        // 如果左侧指针大于右侧，直接返回
        if (left > right) {
            return new ArrayList<>();
        } else {
            List<Integer> resultList = new ArrayList<>();
            // 找到二分位置
            int midIndex = (left + right) / 2;
            // 和对应的值
            int midValue = arr[midIndex];
            // 如果被查找数>二分值
            if (findValue > midValue) {
                // 继续进行右侧二分查找，直到找到findValue
                return search(midIndex + 1, right, arr, findValue);
            } else if (findValue < midValue) {
                // 继续进行左侧二分查找，直到找到findValue
                return search(left, midIndex, arr, findValue);
            } else {
                // 处理有重复的findValue情况
                // 先将第一个找到的加入到返回列表中
                resultList.add(midIndex);

                // 进行左侧查找是否存在
                int temp = midIndex - 1;
                while(temp>0 && arr[temp] == findValue){
                    resultList.add(temp);
                    temp--;
                }
                // 进行右侧查找是否存在
                temp = midIndex + 1;
                while(temp<right && arr[temp] == findValue){
                    resultList.add(temp);
                    temp++;
                }
            }
            return resultList;
        }
    }
}
