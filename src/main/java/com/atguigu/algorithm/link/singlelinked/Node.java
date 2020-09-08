package com.atguigu.algorithm.link.singlelinked;

/**
 * 描述:
 * 节点
 *
 * @create 2020-06-01 11:55
 * @author tongaijie
 */
public class Node {
    private int id;
    private String name;
    private String nickName;
    private Node next;

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

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int id, String name, String nickName, Node next) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
