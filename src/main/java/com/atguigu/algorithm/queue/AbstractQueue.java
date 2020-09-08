package com.atguigu.algorithm.queue;

import java.util.Scanner;

/**
 * 描述:
 * 抽象队列，将一些成员属性抽到公共的抽象类中
 *
 * @create 2020-05-31 16:17
 * @author tongaijie
 */
public class AbstractQueue {

    /** 队列最大长度 */
    private int maxSize;

    /** 队列头指针：第一个数据前面一位 */
    private int front;

    /** 队列尾指针：最后一个数据所在位 */
    private int rear;

    /** 队列 */
    private int[] array;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void ScanQueue(MyQueue queue) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println();
            System.out.println("(a):队列中添加元素");
            System.out.println("(g):取出队列中的第一个元素");
            System.out.println("(f):查询第一个元素");
            System.out.println("(s):查询队列");
            System.out.println("(e):退出");

            String command = scanner.next();
            switch (command){
                case "a":
                    System.out.println("请输入要添加的元素：");
                    int inInt = scanner.nextInt();
                    try {
                        queue.addElement(inInt);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "g":
                    try {
                        System.out.println("取出的元素为：" + queue.getElement());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "f":
                    try {
                        System.out.println("查询头元素：" +queue.getFrontElement());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    System.out.println("退出");
                    flag = false;
                    scanner.close();
                    break;
                default:
            }
        }
    }
}
