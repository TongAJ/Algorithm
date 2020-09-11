package com.atguigu.algorithm.sort;

import com.atguigu.algorithm.uitl.Util;

import java.util.Arrays;

/**
 * 描述:
 * 快速排序算法
 *
 * @author tongaijie-9697
 * @create 2020-09-08 10:09
 */
public class QuickSort implements MySort{

    public static void main(String[] args) {
        int[] result = Util.testTimeCost(100000, new QuickSort());
        System.out.println(Arrays.toString(result));
    }

    /**
     * 快速排序算法
     *
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr, int left, int right) {
        // 左侧下标
        int l = left;
        // 右侧下标
        int r = right;
        // 中轴值
        int pivot = arr[(left + right) / 2];
        // 临时值，用于值得交换
        int temp;
        // 当 左侧下标 < 右侧下标 执行循环，大于，则跳出循环
        while (l < r) {
            // 在左侧寻找比中轴值大的，就会跳出循环，否则一直循环
            while (arr[l] < pivot) {
                l++;
            }
            // 在右侧寻找比中轴值小的，就会跳出循环，否则一直循环
            while (arr[r] > pivot) {
                r--;
            }
            // 如果l>=r，那么表示已经走完了
            if (l >= r) {
                break;
            }
            // 如果没有走完，表示需要交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完，左侧得值等于中轴值，让右侧指针左移
            if(arr[l] == pivot){
                r--;
            }
            // 如果交换完，右侧得值等于中轴值，让左侧指针右移
            if(arr[r] == pivot){
                l++;
            }
        }

        // 当跳出循环，l=r时，将指针进行移动，方便进行左侧和右侧递归的快速排序
        if( l==r ){
            l++;
            r--;
        }

        // 如果r指针还大于left，进行左侧递归快速排序
        if(left < r){
            // 向左递归
            quickSort(arr,left,r);
        }

        // 如果l指针还小于right，进行右侧递归快速排序
        if(l < right){
            // 向左递归
            quickSort(arr,l,right);
        }

        return arr;
    }

    @Override
    public int[] sort(int[] arr) {
        return quickSort(arr,0,arr.length-1);
    }
}
