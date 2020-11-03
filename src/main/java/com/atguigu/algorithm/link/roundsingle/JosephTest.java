package com.atguigu.algorithm.link.roundsingle;

/**
 * 描述:
 * 回忆约瑟夫算法
 *
 * @author tong-aj
 * @create 2020-08-20 14:07
 */
public class JosephTest {

    /**
     * 头节点
     */
    private static RoundLinkedNode head;

    /**
     * 下一个节点
     */
    private static RoundLinkedNode next;

    /**
     * 当前节点
     */
    private static RoundLinkedNode current;

    /**
     * 辅助节点：一般位于头节点的前一个节点
     */
    private static RoundLinkedNode helper;

    /**
     * 往队列中添加指定数量的环形节点
     *
     * @param number
     */
    public static void addNumberToQueue(int number) {
        head = new RoundLinkedNode(1);
        current = head;
        head.setNext(current);
        for (int i = 2; i <= number; i++) {
            next = new RoundLinkedNode(i);
            current.setNext(next);
            if (i != number) {
                current = next;
            } else {
                next.setNext(head);
            }
        }
    }

    /**
     * 展示所有节点
     */
    public static void showNodes() {
        if (head == null) {
            throw new RuntimeException("头节点不存在");
        }
        System.out.println(head);
        current = head.getNext();
        while (true) {
            System.out.println(current);
            if (current.getNext() == head) {
                break;
            } else {
                current = current.getNext();
            }
        }
    }

    /**
     * 约瑟夫算法：根据下面三个参数，数数，数到的人出队列，直到所有人都出队列
     *
     * @param number 一共多少人
     * @param count  数多少次出一个人
     * @param start  从哪一位开始
     */
    public static void countAndOut(int number, int count, int start) {
        // 1:添加队列数量
        addNumberToQueue(number);

        // 2:获取start节点
        current = head.getNext();
        RoundLinkedNode startNode;
        while (true) {
            if (current.getId() == start) {
                startNode = current;
                break;
            } else {
                current = current.getNext();
            }
        }
        System.out.println("开始节点：" + startNode);

        // 3:获取helper节点
        current = startNode.getNext();
        while (true) {
            if (current.getNext() == startNode) {
                helper = current;
                break;
            } else {
                current = current.getNext();
            }
        }
        System.out.println("辅助节点：" + helper);

        // 4:开始数数
        current = startNode;
        while (true) {
            for (int i = 0; i < count; i++) {
                helper = current;
                current = current.getNext();
            }
            System.out.println("出队列节点：" + current);
            helper.setNext(current.getNext());
            if(current == helper){
                System.out.println("踢出最后一位出队列的节点：" + current);
                break;
            }
        }
    }

    public static void main(String[] args) {
        addNumberToQueue(5);
        showNodes();
        countAndOut(5, 3, 1);
    }
}
