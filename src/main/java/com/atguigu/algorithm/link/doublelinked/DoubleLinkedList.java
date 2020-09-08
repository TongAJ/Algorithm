package com.atguigu.algorithm.link.doublelinked;

/**
 * 描述:
 * 双向链表
 *
 * @author tongaijie-9697
 * @create 2020-07-20 11:05
 */
public class DoubleLinkedList {

    /** 头节点 */
    private static final DoubleLinkedNode head = new DoubleLinkedNode(0, "", "", null, null);

    public static void main(String[] args) {
        DoubleLinkedList doubleLinked = new DoubleLinkedList();
        doubleLinked.add(new DoubleLinkedNode(1, "1", "11", null, null));
        doubleLinked.add(new DoubleLinkedNode(2, "2", "22", null, null));
        doubleLinked.add(new DoubleLinkedNode(3, "3", "33", null, null));
        doubleLinked.add(new DoubleLinkedNode(4, "4", "44", null, null));
        doubleLinked.list();

        doubleLinked.update(new DoubleLinkedNode(2, "aaa", "bbb", null, null));
        doubleLinked.list();

        doubleLinked.delete(3);
        doubleLinked.list();
    }

    /**
     * 新增
     *
     * @param node
     */
    private void add(DoubleLinkedNode node) {
        if (head.getNext() == null) {
            // 如果没有，直接新增
            head.setNext(node);
            node.setPre(head);
            System.out.println("新增成功！");
            return;
        } else {
            DoubleLinkedNode temp = head.getNext();
            // 链表有节点，则循环判断，获取最后一个节点
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setPre(temp);
            System.out.println("新增成功!");
        }
    }

    /**
     * 更新
     *
     * @param node
     */
    private void update(DoubleLinkedNode node) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法更新");
        }
        DoubleLinkedNode temp = head.getNext();
        // 匹配标志位
        boolean flag = false;
        while (!flag) {
            // 判断id是否匹配
            if (temp.getId() == node.getId()) {
                flag = true;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(node.getName());
            temp.setNickName(node.getNickName());
            System.out.println("更新成功!");
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    private void delete(int id) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法更新");
        }
        DoubleLinkedNode temp = head.getNext();
        // 匹配标志位
        boolean flag = false;
        while (!flag) {
            // 判断id是否匹配
            if (id == temp.getId()) {
                flag = true;
            }else{
                temp = temp.getNext();
            }
        }
        if (flag) {
            temp.getPre().setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        }
        System.out.println("删除成功!");
    }

    /**
     * 查询所有
     */
    private void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法更新");
            return;
        }
        DoubleLinkedNode temp = head.getNext();
        // 链表有节点，则循环判断，获取最后一个节点
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
