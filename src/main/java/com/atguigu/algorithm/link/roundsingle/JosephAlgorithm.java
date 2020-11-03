package com.atguigu.algorithm.link.roundsingle;

/**
 * 描述:
 * 使用环形单向链表 解决 ：约瑟夫算法
 *
 * @author tong-aj
 * create 2020-07-21 9:20
 */
public class JosephAlgorithm {

    /**
     * 初始节点
     */
    private static RoundLinkedNode first;

    /**
     * 添加指定数量的环形单向链表
     *
     * param number
     */
    private static void add(int number) {
        RoundLinkedNode next;
        RoundLinkedNode current = new RoundLinkedNode(0);
        for (int i = 1; i <= number; i++) {
            // 创建first
            if (i == 1) {
                first = new RoundLinkedNode(i);
                // 创建环形
                first.setNext(first);
                // current 指针
                current = first;
            } else {
                // 创建除了first的节点
                next = new RoundLinkedNode(i);
                next.setNext(first);
                current.setNext(next);
                // 指针后移
                current = next;
            }
        }
    }

    /**
     * 根据指定节点个数，起始节点，和轮流数，打印出出队列的节点顺序
     *
     * param startAt 起始节点
     * param count   轮流数
     * param number  节点个数
     */
    private static void countAndOut(int startAt, int count, int number) {
        // 添加指定个数的环形单向链表
        add(number);
        RoundLinkedNode start = null;
        RoundLinkedNode helper;
        // 获取start节点
        if (startAt == 1) {
            start = first;
        } else {
            for (int j = 0; j < startAt; j++) {
                start = first.getNext();
            }
        }
        System.out.println("start节点:" + start);
        // 创建helper指针，用于定位到first的上一个节点
        helper = start.getNext();
        while (true) {
            if (helper.getNext() == start) {
                break;
            }
            helper = helper.getNext();
        }
        System.out.println("helper节点:" + helper);

        while (true) {
            if (start == helper) {
                System.out.println("最后一个节点为：" + start);
                break;
            }
            // count-1是start指针真正移动的次数
            for (int i = 1; i <= count - 1; i++) {
                // 移动start指针
                start = start.getNext();
                // 移动helper指针
                helper = helper.getNext();
            }
            System.out.println("出队列的节点为：" + start.getId());
            helper.setNext(start.getNext());
            start = start.getNext();
        }
    }

    /**
     * 查询环形单向链表中所有节点
     */
    private static void showNodes() {
        if (first == null) {
            System.out.println("链表中没有节点");
            return;
        }
        System.out.println(first);
        RoundLinkedNode current = first;
        while (current.getNext() != first) {
            System.out.println(current.getNext());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        countAndOut(2, 4, 20);
    }
}
