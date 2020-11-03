package com.atguigu.algorithm.link.roundsingle;

/**
 * 描述:
 * 单向环形链表单个节点
 *
 * @author tong-aj
 * create 2020-07-20 14:04
 */
public class RoundLinkedNode{

    private int id;
    private RoundLinkedNode next;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoundLinkedNode getNext() {
        return next;
    }

    public void setNext(RoundLinkedNode next) {
        this.next = next;
    }

    public RoundLinkedNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoundLinkedNode{" +
                "id=" + id +
                '}';
    }
}
