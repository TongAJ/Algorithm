package com.self.algorithm.tree.order;

import lombok.Data;
import lombok.ToString;

/**
 * Description: 重温线索化二叉树
 *
 * @author tong-aj
 * <p>
 * Create: 2020-11-06 16:01
 */
@Data
public class OrderBinaryTree {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "1");
        HeroNode heroNode2 = new HeroNode(2, "2");
        HeroNode heroNode3 = new HeroNode(3, "3");
        HeroNode heroNode4 = new HeroNode(4, "4");
        HeroNode heroNode5 = new HeroNode(5, "5");
        HeroNode heroNode6 = new HeroNode(6, "6");

        OrderBinaryTree orderBinaryTree = new OrderBinaryTree(heroNode1);
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        System.out.println("线索化二叉树");
        orderBinaryTree.threadedNodes();

        System.out.println("中序遍历顺序打印线索化二叉树");
        orderBinaryTree.threadedList();
    }

    public OrderBinaryTree(HeroNode root) {
        this.root = root;
    }

    private HeroNode root;

    private HeroNode pre;

    public void threadedNodes() {
        threadedNodes(root);
    }

    public void threadedNodes(HeroNode heroNode) {
        if (heroNode == null) {
            return;
        }
        // 向左递归找叶子节点
        threadedNodes(heroNode.getLeft());

        // 处理前驱
        if (heroNode.getLeft() == null) {
            heroNode.setLeft(pre);
            heroNode.setLeftType(1);
        }

        // 处理后继
        if (pre != null && pre.getRight() == null) {
            pre.setRight(heroNode);
            pre.setRightType(1);
        }

        // 赋值pre，表示往后走一步，继续进行线索化赋值
        pre = heroNode;

        // 向右递归找叶子节点
        threadedNodes(heroNode.getRight());
    }

    public void threadedList() {
        if (root == null) {
            System.out.println("空树，无法遍历线索化二叉树");
            return;
        }
        HeroNode temp = root;
        while (temp != null) {
            while (temp.getLeftType() == 0) {
                temp = temp.getLeft();
            }
            System.out.println(temp);
            while (temp.getRightType() == 1) {
                temp = temp.getRight();
                System.out.println(temp);
            }
            temp = temp.getRight();
        }
    }
}

@Data
class HeroNode {
    private Integer id;
    private String name;
    @ToString.Exclude
    private HeroNode left;
    @ToString.Exclude
    private HeroNode right;

    private Integer leftType = 0;
    private Integer rightType = 0;

    public HeroNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}