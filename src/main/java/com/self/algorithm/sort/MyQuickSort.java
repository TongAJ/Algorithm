package com.self.algorithm.sort;

import java.util.Arrays;

/**
 * 描述:
 * 自己编写的快速排序算法
 *
 * @author tongaijie-9697
 * @create 2020-09-09 10:01
 */
public class MyQuickSort {

    public static void main(String[] args) {
        int[] arr = {3,6,1,5};
        System.out.println(Arrays.toString(sort(arr, 0, arr.length - 1)));

    }

    public static int[] sort(int[] arr, int left, int right) {
        // mark the 'l' index
        int lIndex = left;
        // mark the 'r' index
        int rIndex = right;
        // mark the pivotValue value
        int pivotValue = arr[(left + right) / 2];
        // mark the temp,used for exchange
        int temp;

        while (lIndex < rIndex) {
            // find the larger value when move 'l' index
            while (arr[lIndex] < pivotValue) {
                lIndex++;
            }
            // find the larger value when move 'l' index
            while (arr[rIndex] > pivotValue) {
                rIndex--;
            }
            // if two indexes meets, means filter all elements in array
            if(lIndex>=rIndex){
                break;
            }
            // if not break; means find the larger or the smaller one,then exchange
            temp = arr[lIndex];
            arr[lIndex] = arr[rIndex];
            arr[rIndex] = temp;

            // when equals, r index --, skip the pivotValue value
            if(arr[lIndex] == pivotValue){
                rIndex--;
            }
            // when equals, l index ++, skip the pivotValue value
            if(arr[rIndex] == pivotValue){
                lIndex++;
            }
        }
        // if equals,two index moves to run the recursion
        if( lIndex== rIndex){
            lIndex++;
            rIndex--;
        }
        // pivotValue left recursion
        if(left<rIndex){
            sort(arr,left,rIndex);
        }
        // pivotValue right recursion
        if(right>lIndex){
            sort(arr,lIndex,right);
        }

        return arr;
    }
}
