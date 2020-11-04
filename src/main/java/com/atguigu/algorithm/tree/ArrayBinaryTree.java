package com.atguigu.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: 数组二叉树
 *
 * @author tong-aj
 * <p>
 * Create: 2020-11-04 10:05
 */

@Data
@AllArgsConstructor
public class ArrayBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        // 期望输出顺序：1,2,4,5,3,6,7
        System.out.println("前序");
        new ArrayBinaryTree(arr).prefix();
        // 期望输出顺序：4,2,5,1,6,3,7
        System.out.println("中序");
        new ArrayBinaryTree(arr).mid();
        // 期望输出顺序：4,5,2,6,7,3,1
        System.out.println("后序");
        new ArrayBinaryTree(arr).suffix();
    }

    private int[] arr;

    /**
     * Description: 以前序遍历方式，二叉树以数组的顺序展示数据
     * Param: [id]
     * return: void
     * Author: tong-aj
     * Date: 2020/11/4
     */
    private void prefixInArr(Integer index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组不能为空");
        }
        // 输出当前节点
        System.out.println(arr[index]);
        // 如果2n+1<length才向左递归前序
        if(2*index+1<arr.length){
            prefixInArr(2*index+1);
        }
        // 如果2n+2<length才向右递归前序
        if(2*index+2<arr.length){
            prefixInArr(2*index+2);
        }
    }

    /**
    * Description: 用中序遍历，以数组顺序的方式展示数据
    * Param: [index]
    * return: void
    * Author: tong-aj
    * Date: 2020/11/4
    */
    private void midInArr(Integer index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组不能为空");
        }
        // 如果2n+1<length才向左递归前序
        if(2*index+1<arr.length){
            midInArr(2*index+1);
        }
        // 输出当前节点
        System.out.println(arr[index]);
        // 如果2n+2<length才向右递归前序
        if(2*index+2<arr.length){
            midInArr(2*index+2);
        }
    }

    private void suffixInArr(Integer index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组不能为空");
        }
        // 如果2n+1<length才向左递归前序
        if(2*index+1<arr.length){
            suffixInArr(2*index+1);
        }
        // 如果2n+2<length才向右递归前序
        if(2*index+2<arr.length){
            suffixInArr(2*index+2);
        }
        // 输出当前节点
        System.out.println(arr[index]);
    }
    
    /**
    * Description: 前序遍历，顺序展示数组
    * Param: []
    * return: void
    * Author: tong-aj
    * Date: 2020/11/4
    */
    public void prefix(){
        // 默认从数组第0位开始
        this.prefixInArr(0);
    }

    /**
    * Description: 中序遍历，顺序展示数组
    * Param: []
    * return: void
    * Author: tong-aj
    * Date: 2020/11/4
    */
    public void mid(){
        // 默认从数组第0位开始
        this.midInArr(0);
    }

    /**
    * Description: 后序遍历，顺序展示数组
    * Param: []
    * return: void
    * Author: tong-aj
    * Date: 2020/11/4
    */
    public void suffix(){
        // 默认从数组第0位开始
        this.suffixInArr(0);
    }
}
