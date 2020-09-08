package com.atguigu.algorithm.sparse;

import java.io.*;

/**
 * 描述:
 * 稀疏数组
 *
 * @create 2020-05-29 21:57
 * @author tongaijie
 */
public class SparseArray {

    /** 1： 11*11 的棋盘 */
    private static int[][] chess = new int[11][11];

    private static int[][] sparseArray;


    public static void main(String[] args) {
        // 1表示黑子
        chess[1][2] = 1;
        // 2表示蓝子
        chess[2][3] = 2;
        printChess(chess);
        int counts = getCountsOfSparseArray();
        sparseArray = changeToSparseArray(counts,chess);
        printChess(sparseArray);

        int[][] chessMock = changeToChess(sparseArray);
        printChess(chessMock);

        generateArrayFile(chess,"Chess.txt");
        generateArrayFile(sparseArray,"SparseArray.txt");
    }

    /**
     * 打印棋盘
     * @param chess
     */
    public static void printChess(int[][] chess){
        for (int[] row : chess){
            System.out.println();
            for(int item : row){
                System.out.printf("%d\t",item);
            }
        }
        System.out.println();
    }

    public static int getCountsOfSparseArray(){
        // 1：获取棋盘上非0数字的个数
        int num = 0;
        int rows = chess.length;
        int length = chess[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                if(chess[i][j] != 0){
                    num++;
                }
            }
        }
        System.out.println("不是0的个数有\t");
        System.out.println(num);
        return num;
    }

    public static int[][] changeToSparseArray(int counts, int[][] chess){
        int rows = chess.length;
        int length = chess[0].length;
        int[][] sparseArray = new int[counts+1][3];
        sparseArray[0][0] = chess.length;
        sparseArray[0][1] = chess[1].length;
        sparseArray[0][2] = counts;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                if(chess[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chess[i][j];
                }
            }
        }
        return sparseArray;
    }

    public static int[][] changeToChess(int[][] array){
        int num = sparseArray[0][2];
        int row = sparseArray[0][0];
        int length = sparseArray[0][1];

        int[][] chessMock = new int[row][length];

        for (int i = 1; i <= num; i++) {
            chessMock[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return chessMock;
    }

    public static void generateArrayFile(int[][] array,String fileName){
        // 1：创建文件实例
        File file = new File(fileName);
        FileWriter fileWriter = null;
        try {
            // 2：创建流的实例
            fileWriter = new FileWriter(file);

            // 3：操作流
            int row = array.length;
            int length = array[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < length; j++) {
                    fileWriter.write(String.valueOf(array[i][j])+" ");
                }
                fileWriter.write("\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
