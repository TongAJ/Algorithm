package com.atguigu.algorithm.tree;

/**
 * Description: 模拟二叉树
 *
 * @author tongaijie
 * <p>
 * Create: 2020-11-02 10:19
 */
public class HeroNodeDemo {

    public static void main(String[] args) {
        // 构造树
        HeroNode heroNode1 = new HeroNode(1, "1");
        HeroNode heroNode2 = new HeroNode(2, "2");
        HeroNode heroNode3 = new HeroNode(3, "3");
        HeroNode heroNode4 = new HeroNode(4, "4");
        HeroNode heroNode5 = new HeroNode(5, "5");
        HeroNode heroNode6 = new HeroNode(6, "6");

        heroNode2.setLeft(heroNode1);
        heroNode2.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode4.setRight(heroNode5);
        heroNode5.setRight(heroNode6);

        HeroNodeTree heroNodeTree = new HeroNodeTree(heroNode2);
        heroNodeTree.prefix();

    }

}

/**
 * 树节点
 */
class HeroNode{

    private Integer id;
    private String name;
    private HeroNode left ;
    private HeroNode right ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
    * Description: 前序，先输出根节点，然后左子树，最后右子树
    * Param: [heroNode]
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void prefix(HeroNode heroNode){
        System.out.println(heroNode);
        if(heroNode.getLeft() != null){
            this.prefix(heroNode.getLeft());
        }
        if(heroNode.getRight() != null){
            this.prefix(heroNode.getRight());
        }
    }

    /**
    * Description: 中序，先输出左子树，然后根节点，最后右子树
    * Param: [heroNode]
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void preMid(HeroNode heroNode){
        if(heroNode.getLeft() != null){
            this.preMid(heroNode.getLeft());
        }
        System.out.println(heroNode);
        if(heroNode.getRight() != null){
            this.preMid(heroNode.getRight());
        }
    }

    /**
    * Description: 后序遍历，先左子树，然后右子树，最后根节点
    * Param: [heroNode]
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void suffix(HeroNode heroNode){
        if(heroNode.getLeft() != null){
            this.suffix(heroNode.getLeft());
        }
        if(heroNode.getRight() != null){
            this.suffix(heroNode.getRight());
        }
        System.out.println(heroNode);
    }

    // 三种遍历方式，前中后就是根节点的打印顺序
}

class HeroNodeTree{

    private HeroNode root;

    public HeroNodeTree(HeroNode root) {
        this.root = root;
    }

    public void prefix(){
        root.prefix(root);
    }

}