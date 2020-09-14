package com.self.algorithm.recursion;

import java.util.Arrays;

/**
 * 描述:
 * 自己编写八皇后
 *
 * @author tongaijie-9697
 * 2020-09-14 10:33
 */
public class MyEightQueen {

    /** 棋盘大小 */
    private static final int MAX_LENGTH = 8;

    /** 创建最后皇后所在位置稀疏数组 */
    private static int[] queensArr = new int[MAX_LENGTH];

    /** 记录放置了多少皇后 */
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
        for (int i = 0; i < x ; i++) {
            // 是否在同一行或者同一斜线上
            if (queensArr[i] == queensArr[x] || Math.abs(x-i)==Math.abs(queensArr[x]-queensArr[i])) {
                return true;
            }
        }
        return false;
    }


    public static void setQueens(int spot) {
        if(count>MAX_LENGTH){
            return;
        }else{
            for (int i = 0; i < MAX_LENGTH; i++) {
                queensArr[spot] = i;
                if(!isConflict(spot,queensArr)){
                    count++;
                    setQueens(spot+1);
                }
            }
        }
    }
}
