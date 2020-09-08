package com.atguigu.algorithm.link.singlelinked;

/**
 * 描述:
 * 单向链表，基本功能
 *
 * @create 2020-05-31 22:05
 * @author tongaijie
 */
public class SingleLinkList {

    /** 头节点 */
    private final Node head = new Node(0, "", "", null);

    /**
     * 按添加顺序添加节点
      * @param node
     */
    public void addElement(Node node) {
        // 获取第一个元素
        Node temp = head.getNext();
        if (temp == null) {
            head.setNext(node);
            return;
        } else {
            while (true) {
                if (temp.getNext() == null) {
                    break;
                }
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    /**
     * 按节点ID顺序添加节点
      * @param node
     */
    public void addElementByOrder(Node node) {
        // 获取第一个元素
        Node temp = head.getNext();
        // 第一次添加
        if (temp == null) {
            head.setNext(node);
            return;
        } else {
            boolean flag = true;
            while (flag) {
                if (temp.getNext() == null) {
                    temp.setNext(node);
                    flag = false;
                } else {
                    Node next = temp.getNext();
                    // 如果新增节点ID大于next的节点，那么继续循环
                    // 如果反之，则将新增节点添加至原next之前
                    flag = node.getId() > next.getId();
                    if (flag) {
                        temp = temp.getNext();
                    } else {
                        temp.setNext(node);
                        node.setNext(next);
                    }
                }
            }
        }
    }

    public void updateElement(Node node) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.getNext();
        boolean flag = false;
        while (true) {
            if(temp.getId() == node.getId()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag){
            temp.setName(node.getName());
            temp.setNickName(node.getNickName());
        }else{
            System.out.println("需要更新的节点不存在");
        }
    }

    public void deleteElement(int id) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node first = head;
        Node temp = head.getNext();
        boolean flag = false;
        while (true) {
            if(temp.getId() == id){
                if(temp.getNext() == null){
                    first.setNext(null);
                }
                first.setNext(temp.getNext());
                flag = true;
                break;
            }
            first = temp;
            temp = temp.getNext();

        }
        if(!flag){
            System.out.println("需要更新的节点不存在");
        }
    }


    public void showNodes() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = true;
        Node temp = head.getNext();
        while (flag) {
            System.out.println(temp);
            if (temp.getNext() == null) {
                flag = false;
            }
            temp = temp.getNext();
        }
    }

    public Node findLastIndexNode(int index){
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return null;
        }
        if(index <=0 || index>size()){
            System.out.println("并没有倒数第+" + index +"的节点");
            return null;
        }
        Node temp = head.getNext();
        for(int i = 0; i< size()-index; i++){
            temp = temp.getNext();
        }
        return temp;
    }



    public int size(){
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return 0;
        }
        Node temp = head.getNext();
        int count = 1;
        while(true){
            if(temp.getNext()==null){
                break;
            }
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, "tong1", "AJ1", null);
        Node node2 = new Node(2, "tong2", "AJ2", null);
        Node node3 = new Node(3, "tong3", "AJ3", null);
        Node node4 = new Node(4, "tong4", "AJ4", null);
        SingleLinkList singleLinkList = new SingleLinkList();
        /*singleLinkList.addElement(node1);
        singleLinkList.addElement(node4);
        singleLinkList.addElement(node3);
        singleLinkList.addElement(node2);*/

        singleLinkList.addElementByOrder(node1);
        singleLinkList.addElementByOrder(node4);
        singleLinkList.addElementByOrder(node3);
        singleLinkList.addElementByOrder(node2);

        singleLinkList.showNodes();
        System.out.println();

        singleLinkList.updateElement(new Node(1, "tong11", "AJ11", null));
        singleLinkList.showNodes();
        System.out.println();

        singleLinkList.deleteElement(1);
        singleLinkList.showNodes();
        System.out.println();

        System.out.println("size: "+singleLinkList.size());
        System.out.println();

        Node lastIndexNode = singleLinkList.findLastIndexNode(3);
        System.out.println(lastIndexNode);
    }

}
