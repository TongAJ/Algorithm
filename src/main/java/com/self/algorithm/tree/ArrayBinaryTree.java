package com.self.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: 以数组的顺序展示二叉树
 * {1，2，3，4，5，6}
 * 遵从三种遍历方式
 *      以前序为例子：
 *          从当前节点开始展示数组的第 index 位的值
 *          root 位 arr[0]
 *          那么 root 的左字节点位 arr[2 * 0 + 1]
 *                  以当前节点进行向左递归，
 *                      即 arr[1] 的左子节点位 arr[1 * 2 + 1],
 *                      即 arr[1] 的右子节点位 arr[1 * 2 + 2],
 *          那么 root 的右字节点位 arr[2 * 0 + 2]
 *          ...
 *
 *          以此类推
 *
 * @author tong-aj
 *
 * Create: 2020-11-06 13:57
 */

@Data
@AllArgsConstructor
public class ArrayBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        System.out.println("前序输出数组：");
        new ArrayBinaryTree(arr).prefixList();
        System.out.println();

        System.out.println("中序输出数组：");
        new ArrayBinaryTree(arr).midList();
        System.out.println();

        System.out.println("后序输出数组：");
        new ArrayBinaryTree(arr).suffixList();
        System.out.println();
    }

    private int[] arr;

    public void prefixList(){
        if(arr == null && arr.length == 0){
            System.out.println("数组为空，无法进行前序遍历");
            return;
        }
        this.prefixList(0);
    }

    private void prefixList(Integer index) {
        System.out.println(arr[index]);
        if(2*index +1 < arr.length){
            prefixList(2*index +1);
        }
        if(2*index +2 < arr.length){
            prefixList(2*index +2);
        }
    }

    public void midList(){
        if(arr == null && arr.length == 0){
            System.out.println("数组为空，无法进行前序遍历");
            return;
        }
        this.midList(0);
    }

    private void midList(Integer index) {
        if(2*index +1 < arr.length){
            midList(2*index +1);
        }
        System.out.println(arr[index]);
        if(2*index +2 < arr.length){
            midList(2*index +2);
        }
    }

    public void suffixList(){
        if(arr == null && arr.length == 0){
            System.out.println("数组为空，无法进行前序遍历");
            return;
        }
        this.suffixList(0);
    }

    private void suffixList(Integer index) {
        if(2*index +1 < arr.length){
            suffixList(2*index +1);
        }
        if(2*index +2 < arr.length){
            suffixList(2*index +2);
        }
        System.out.println(arr[index]);
    }



}
