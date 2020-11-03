package com.atguigu.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 使用递归解决迷宫问题
 *
 * @author tong-aj
 * create 2020-08-31 15:23
 */
public class Puzzle {

    /** 空白处 */
    private static int BLANK = 0;

    /** 墙或者挡板 */
    private static int BLOCK = 1;

    /** 经过的路径 */
    private static int GO_THROUGH = 2;

    /** 死路 */
    private static int BACK = 3;

    /** 终点x */
    private static int FINAL_X = 6;

    /** 终点y */
    private static int FINAL_Y = 6;

    /** 迷宫 */
    private static int[][] puzzle;

    public static void main(String[] args) {
        int length = 7;
        int weight = 7;

        initPuzzle(length, weight);
        List<int[]> blocks = initBlocks();
        setWallAndBlocks(length, weight, blocks);
        //  起始位置为（1，1），根据寻路规则往终点走
        findWays(1, 1);
        showPuzzle();

        // tips：最短路径问题，通过设置不同的寻路规则，计算每个寻路规则下走的步数，进行比较
    }

    /**
     * 初始化挡板位置
     * return
     */
    public static List<int[]> initBlocks() {
        List<int[]> blocks = new ArrayList<>();
        int[] block_one = {1, 3};
        blocks.add(block_one);

        int[] block_two = {2, 3};
        blocks.add(block_two);

        int[] block_three = {4, 3};
        blocks.add(block_three);

        int[] block_four = {4, 4};
        blocks.add(block_four);

        int[] block_five = {5, 4};
        blocks.add(block_five);

        return blocks;
    }

    /**
     * 初始化迷宫
     *
     * param length
     * param weight
     * return
     */
    public static int[][] initPuzzle(int length, int weight) {
        puzzle = new int[length][weight];
        return puzzle;
    }

    /**
     * 显示迷宫
     */
    public static void showPuzzle() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 初始化墙和挡板
     *
     * param length
     * param weight
     * param blocks
     */
    public static void setWallAndBlocks(int length, int weight, List<int[]> blocks) {
        // 初始化四周的墙壁
        // 两个长面
        int last = length - 1;
        for (int i = 0; i < length; i++) {
            puzzle[0][i] = BLOCK;
            puzzle[last][i] = BLOCK;
        }
        // 两个宽面
        last = weight - 1;
        for (int i = 1; i < weight; i++) {
            puzzle[i][0] = BLOCK;
            puzzle[i][last] = BLOCK;
        }

        // 将block赋值到迷宫
        for (int i = 0; i < blocks.size(); i++) {
            int x = blocks.get(i)[0];
            int y = blocks.get(i)[1];
            puzzle[x][y] = BLOCK;
        }
    }

    /**
     * 从X，Y坐标开始寻找走向终点的路
     *
     * param x
     * param y
     * return
     */
    public static boolean findWays(int x, int y) {
        // 如果找到了终点，直接返回
        if (puzzle[FINAL_X][FINAL_Y] == GO_THROUGH) {
            return true;
        } else if (puzzle[x][y] == BLANK) {
            // 没有走过，先将当前位置标位走过
            puzzle[x][y] = GO_THROUGH;
            // 按照既定的寻找策列为：右->下->左->上
            if (findWays(x, y + 1)) {
                // 右
                return true;
            } else if (findWays(x + 1, y)) {
                // 下
                return true;
            } else if (findWays(x, y - 1)) {
                // 左
                return true;
            } else if (findWays(x - 1, y)) {
                // 上
                return true;
            } else {
                // 死路,需要回溯
                puzzle[x][y] = BACK;
                return false;
            }
        } else if (puzzle[x][y] == BLOCK || puzzle[x][y] == BACK) {
            return false;
        }
        return true;
    }

}
