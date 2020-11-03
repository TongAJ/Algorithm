package com.atguigu.algorithm.recursion;

/**
 * 描述:
 * 使用递归解决八皇后问题
 *
 * @author tong-aj
 * create 2020-09-01 14:26
 */
public class EightQueen {

    /** 能放置的皇后的数量 */
    private static int max = 8;

    /**
     * 存放最后皇后所在位置结果
     *      数组的下标表示第index个皇后
     *      数组的值表示第index个皇后放置在 第 index 行的第 index+1 列上、
     *      如 {0，4，3.....}
     *      第一个皇后，放在第0行第1列
     *      第二个皇后，放在第1行第5列
     *      依次类推
     */
    private static int[] result = new int[max];

    /** 记录总共有多少种可能性 */
    private static int count = 0;

    public static void main(String[] args) {
        chess(0);
        System.out.println(count);
    }

    /**
     * 打印出所有结果
     */
    public static void showResult(){
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    /**
     * 判断第 n 个棋子和前面所有的是否有冲突
     *      即：不能处于同一列，也不能再同一斜线上
     * param n
     * return
     */
    public static boolean isConflict(int n){
        for (int i = 0; i < n; i++) {
            if(result[n] == result[i]){
                // 表示第n个皇后和前面的某个皇后在同一列
                return false;
            } else if(Math.abs(n-i) == Math.abs(result[n]-result[i])){
                // 表示第n个皇后和前面的某个皇后在同一斜线
                // 即 两个皇后之间，横坐标的差值的绝对值和纵坐标的差值的绝对值，如果一样，就在一条写线上
                return false;
            }
        }
        // 都不冲突，返回true
        return true;
    }

    /**
     * 将第n个棋子放入棋盘中
     * param n
     */
    public static void chess(int n){
        if(n == max){
            // 如果n为8，表示前面8个棋子已经放好了，可以查看结果
            showResult();
            // 记录数+1
            count++;
        } else{
            // 第一个皇后从第一行的第一列，逐一放置到最后一列，求出每一列的所有可能性
            for (int i = 0; i < max; i++) {
                // 先将第n个皇后放好
                result[n] = i;
                // 判断和前面所有放好的皇后是否有冲突
                if(isConflict(n)){
                    // 如果都没有，继续放下一个皇后
                    chess(n+1);
                }
                // 如果与任何一个先前的皇后有冲突，将当前的皇后往同一行的后一列进行摆放
                // 即回溯，重新摆放当前的皇后
            }
        }
    }
}
