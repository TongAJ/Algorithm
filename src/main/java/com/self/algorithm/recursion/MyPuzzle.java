package com.self.algorithm.recursion;

/**
 * 描述:
 * 自己编写使用递归来解决迷宫问题
 *
 * @author tongaijie-9697
 * create 2020-09-11 13:28
 */
public class MyPuzzle {

    static int[][] puzzle = new int[8][8];

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            puzzle[i][0] = 1;
            puzzle[i][7] = 1;
        }
        for (int i = 0; i < 8; i++) {
            puzzle[0][i] = 1;
            puzzle[7][i] = 1;
        }
        showPuzzle();
        System.out.println();
        findWays(1, 1);
        showPuzzle();
    }

    public static boolean findWays(int x, int y) {
        if (puzzle[6][6] == 2) {
            return true;
        } else if (puzzle[x][y] == 0) {
            puzzle[x][y] = 2;
            if (findWays(x, y + 1)) {
                return true;
            } else if (findWays(x + 1, y)) {
                return true;
            } else if (findWays(x, y - 1)) {
                return true;
            } else if (findWays(x - 1, y)) {
                return true;
            } else {
                puzzle[x][y] = 3;
                return false;
            }
        } else if (puzzle[x][y] == 1 || puzzle[x][y] == 3) {
            return false;
        }
        return true;
    }

    public static void showPuzzle() {
        System.out.println();
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
