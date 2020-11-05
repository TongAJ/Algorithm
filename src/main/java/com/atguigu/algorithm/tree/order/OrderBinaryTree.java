package com.atguigu.algorithm.tree.order;

import lombok.Data;
import lombok.ToString;

/**
 * Description: 线索化二叉树。
 * 完全二叉树的情况下，子节点的 left、right 指针都是空着的
 * 线索化即给这些空着的 left 和 right 指针进行赋值，赋值的就是节点的
 * 前驱
 * 后继
 * <p>
 * 例子：1，2，3，4，5，6 以中序遍历方式，
 *          1
 *      2       3
 *  4      5  6
 * 查询结果为：4，2，5，1，6，3
 * 那么 对于节点4而言，没有前驱节点，但是有后继节点，为节点2
 * 对于节点5而言，前驱节点时节点2，后继节点为节点1
 * 对于节点1而言，即没有前驱节点又没有后继节点
 * 对于节点6而言，前驱节点为节点3，但没有后继节点
 *
 * @author tong-aj
 * <p>
 * Create: 2020-11-04 17:12
 */

@Data
public class OrderBinaryTree {

    // 根节点
    private HeroNode root;

    // 前驱节点，由于二叉树时不可逆的，如果没有一个前驱的辅助指针，那么很难对前驱节点进行赋值
    // pre 总是保留前一个节点
    private HeroNode pre;

    public OrderBinaryTree(HeroNode root) {
        this.root = root;
    }

    /**
     * Description: 以中序遍历为例子，线索化节点，对 left，right 指针为空的子节点进行线索化赋值前驱节点和后继节点
     * Param: [heroNode]
     * return: void
     * Author: tong-aj
     * Date: 2020/11/5
     */
    public void threadedNodes(HeroNode heroNode) {
        // 如果当前节点为空，则不能继续
        if (heroNode == null) {
            return;
        }
        //左子节点中序遍历
        threadedNodes(heroNode.getLeft());

        // 处理前驱节点和后继节点的逻辑
        // 以 节点4 为例
        // 当节点4的左指针为空
        if(heroNode.getLeft() == null){
            // 赋值前驱节点 为 pre
            heroNode.setLeft(pre);
            // 类型赋值为线索化节点
            heroNode.setLeftType(1);
        }

        // 原本pre默认为null，当pre不为null时，表示heroNode往后走了一位
        // 即现在走到了节点2，那么节点2的pre为节点4
        if(pre != null && pre.getRight() == null){
            // 赋值后继节点
            pre.setRight(heroNode);
            // 赋值类型为线索化节点
            pre.setRightType(1);
        }

        // 每走一步，都赋值pre，让pre保持为上一步走的节点
        pre = heroNode;

        //右子节点中序遍历
        threadedNodes(heroNode.getRight());
    }


    // 测试线索化排序
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

        orderBinaryTree.threadedNodes(heroNode1);

        System.out.println(heroNode4.getRight());
        System.out.println(heroNode6.getRight());
        System.out.println(heroNode5.getLeft());
        System.out.println(heroNode5.getRight());
    }
}

@Data
@ToString
class HeroNode {

    private Integer id;
    private String name;
    // 两个type，1 表示 线索化，0 表示正常节点
    private Integer leftType;
    private Integer rightType;
    @ToString.Exclude
    private HeroNode left;
    @ToString.Exclude
    private HeroNode right;

    public HeroNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
