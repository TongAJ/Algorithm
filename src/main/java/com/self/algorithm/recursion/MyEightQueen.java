package com.self.algorithm.recursion;

import java.util.Arrays;

/**
 * 描述:
 * 自己编写八皇后
 *
 * @author tong-aj
 * 2020-09-14 10:33
 */
public class MyEightQueen {

    /**
     * 棋盘大小
     */
    private static final int MAX_LENGTH = 8;

    /**
     * 创建最后皇后所在位置稀疏数组
     */
    private static final int[] queensArr = new int[MAX_LENGTH];

    /**
     * 记录放置了多少皇后
     */
    private static int count = 0;

    public static void main(String[] args) {
        setQueens(0);
        System.out.println(Arrays.toString(queensArr));
    }

    /**
     * 检验当前皇后位置和数组中已放置皇后的所有位置是否在攻击范围内
     *
     * @param queensArr 皇后稀疏数组
     * @return 返回是否冲突
     */
    public static boolean isConflict(int x, int[] queensArr) {
        for (int i = 0; i < x; i++) {
            // 是否在同一行，即数组中的值是否相同
            // 是否在同一斜线上，即横坐标差值和纵坐标插值1：1，即相等
            if (queensArr[i] == queensArr[x] || Math.abs(x - i) == Math.abs(queensArr[x] - queensArr[i])) {
                // 冲突
                return true;
            }
        }
        // 不冲突
        return false;
    }

    /**
     * 放置皇后
     *
     * @param spot 第几个皇后
     */
    public static void setQueens(int spot) {
        // 如果已经放了8个，则不继续执行
        if (count <= MAX_LENGTH) {
            for (int i = 0; i < MAX_LENGTH; i++) {
                // 第几个皇后放在第i个位置
                queensArr[spot] = i;
                // 放置之后进行冲突验证
                if (!isConflict(spot, queensArr)) {
                    // 不冲突，则count++
                    count++;
                    // 放置下一个
                    setQueens(spot + 1);
                }
            }
        }
    }
}
