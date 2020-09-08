package com.atguigu.algorithm.link.doublelinked;

/**
 * 描述:
 * 节点
 *
 * @create 2020-06-01 11:55
 * @author tongaijie
 */
public class DoubleLinkedNode {
    private int id;
    private String name;
    private String nickName;
    private DoubleLinkedNode pre;
    private DoubleLinkedNode next;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public DoubleLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode next) {
        this.next = next;
    }

    public DoubleLinkedNode getPre() {
        return pre;
    }

    public void setPre(DoubleLinkedNode pre) {
        this.pre = pre;
    }

    public DoubleLinkedNode(int id, String name, String nickName, DoubleLinkedNode pre, DoubleLinkedNode next) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
