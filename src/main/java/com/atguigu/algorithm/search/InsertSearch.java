package com.atguigu.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 插值查找算法
 *
 * @author tongaijie-9697
 * 2020-09-15 14:58
 */
public class InsertSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        List<Integer> search = search(0, arr.length - 1, arr, 12);
        System.out.println(Arrays.toString(search.toArray()));
    }

    public static List<Integer> search(int left, int right, int[] arr, int findValue) {
        System.out.println("search");
        if (left > right) {
            return new ArrayList<>();
        } else {
            List<Integer> resultList = new ArrayList<>();

            int midIndex = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
            int midValue = arr[midIndex];

            if (findValue > midValue) {
                return search(midIndex + 1, right, arr, findValue);
            } else if (findValue < midValue) {
                return search(left, midIndex - 1, arr, findValue);
            } else {
                resultList.add(midIndex);
                int temp = midIndex - 1;
                while(temp>0 && arr[temp] == findValue){
                    resultList.add(temp);
                    temp--;
                }
                temp = midIndex + 1;
                while(temp>0 && arr[temp] == findValue){
                    resultList.add(temp);
                    temp++;
                }
            }
            return resultList;
        }
    }
}
