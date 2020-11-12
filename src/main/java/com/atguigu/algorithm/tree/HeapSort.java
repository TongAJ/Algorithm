package com.atguigu.algorithm.tree;

import java.util.Arrays;

/**
 * Description: 堆排序
 *
 * @author tong-aj
 * <p>
 * Create: 2020-11-10 10:18
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 9, 8, 3, 10};
        heapSort(arr);
    }

    /**
     * Description:
     * 步骤 1：
     * 将数组根据 升序 / 降序 要求，转换为 大 / 小 顶堆的数组
     * 找到树的所有非叶子节点，然后从靠左靠下的开始
     * 与自己的左子节点和右子节点进行比较，将较小的子节点和自己位置互换
     * 步骤 2：
     * 将数组进行比较，最 大 / 小 的值和数组最后一位进行位置交换
     * 将数组进行比较（除了最后一位），进行交换
     * 循环此步骤，直至数组只剩下最后一个数字
     *
     * Param: [arr]
     * return: void
     * Author: tong-aj
     * Date: 2020/11/10
     */
    public static void heapSort(int[] arr) {
        // 定义结果数组
        int[] result = new int[arr.length];
        // 找到数组中所有的非叶子节点
        for (int i = arr.length/2-1; i >=0 ; i--) {
            // 调整数组
            result = adjustHeap(arr,i,arr.length);
        }
        // 循环将第一个数和最后一个数进行交替，然后移除最后一个数，进行堆排序
        for (int i = arr.length-1; i >0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr,0,i);
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * Description: 调整数组
     * Param: [arr：待调整的数组, index：非叶子节点所在的下标位置, length：多少个元素需要被调整]
     * return: int[]
     * Author: tong-aj
     * Date: 2020/11/10
     */
    private static int[] adjustHeap(int[] arr, int index, int length) {
        // 临时遍历保存当前节点的值
        int temp = arr[index];
        // 循环当前节点下的所有非叶子节点,k位非叶子节点的左子节点，k+1则是右子节点
        for (int k = 2 * index + 1; k < length; k = k * 2 + 1 ) {
            // 判断当前下标节点的左右子节点的大小，并定位到较大的子节点上
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // 移动k
            }
            // 如果较大子节点大于当前节点，则进行交换位置
            if(arr[k]>temp){
                arr[index] = arr[k];
                arr[k] = temp;
                index = k;
            }else{
                break;
            }
        }
        return arr;
    }

}
