package com.self.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString.Exclude;

/**
 * Description: 自己编写二叉树Demo
 *
 * @author tong-aj
 * <p>
 * Create: 2020-11-05 14:56
 */
public class HeroNodeDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "1");
        HeroNode heroNode2 = new HeroNode(2, "2");
        HeroNode heroNode3 = new HeroNode(3, "3");
        HeroNode heroNode4 = new HeroNode(4, "4");
        HeroNode heroNode5 = new HeroNode(5, "5");
        HeroNode heroNode6 = new HeroNode(6, "6");

        HeroNodeTree tree = new HeroNodeTree(heroNode1);

        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        System.out.println("前序遍历二叉树");
        tree.treePrefix();
        System.out.println("中序遍历二叉树");
        tree.treeMid();
        System.out.println("后序遍历二叉树");
        tree.treeSuffix();

        System.out.println("前序搜素：");
        System.out.println(tree.treePrefixSearch(6));
        System.out.println("中序搜素：");
        System.out.println(tree.treeMidSearch(6));
        System.out.println("后序搜素：");
        System.out.println(tree.treeSuffixSearch(6));

        System.out.println("删除节点：节点2");
        tree.treeRemoveNode(2);

        System.out.println("前序遍历二叉树");
        tree.treePrefix();
    }
}

@Data
class HeroNode {
    private Integer id;
    private String name;
    @Exclude
    private HeroNode left;
    @Exclude
    private HeroNode right;

    public HeroNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public void prefix() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().prefix();
        }
        if (this.getRight() != null) {
            this.getRight().prefix();
        }
    }

    public void mid() {
        if (this.getLeft() != null) {
            this.getLeft().mid();
        }
        System.out.println(this);
        if (this.getRight() != null) {
            this.getRight().mid();
        }
    }

    public void suffix() {
        if (this.getLeft() != null) {
            this.getLeft().suffix();
        }
        if (this.getRight() != null) {
            this.getRight().suffix();
        }
        System.out.println(this);
    }

    public HeroNode prefixSearch(Integer id) {
        // 判断当前节点是否匹配
        if (this.getId().equals(id)) {
            System.out.println("找到了匹配的节点: " + this);
            return this;
        }
        // 如果不匹配，则打印
        System.out.println("节点: " + this + "并不匹配");
        // 定义辅助变量
        HeroNode result = null;
        // 进行左子树递归搜索
        if (this.getLeft() != null) {
            result = this.getLeft().prefixSearch(id);
        }
        // 找到递归的结果
        if (result != null) {
            return result;
        }
        if (this.getRight() != null) {
            result = this.getRight().prefixSearch(id);
        }
        return result;
    }

    public HeroNode midSearch(Integer id) {
        HeroNode result = null;
        // 先向左子树遍历节点
        if (this.getLeft() != null) {
            result = this.getLeft().midSearch(id);
        }
        // 找到结果，则返回
        if (result != null) {
            return result;
        }
        // 节点匹配情况
        if (this.getId().equals(id)) {
            System.out.println("找到了匹配的节点: " + this);
            return this;
        }
        // 没有找到，打印
        System.out.println("节点: " + this + "并不匹配");

        if (this.getRight() != null) {
            result = this.getRight().midSearch(id);
        }
        return result;
    }

    public HeroNode suffixSearch(Integer id){
        HeroNode result = null;
        if(this.getLeft() != null){
            result = this.getLeft().suffixSearch(id);
        }
        if(this.getRight() != null){
            result = this.getRight().suffixSearch(id);
        }
        if(result != null){
            return result;
        }
        if(this.getId().equals(id)){
            System.out.println("找到了匹配的节点: " + this);
            return this;
        }
        System.out.println("节点: " + this + "并不匹配");
        return null;
    }

    public void removeNode(Integer id){
        if(this.getLeft() != null && this.getLeft().getId().equals(id)){
            this.setLeft(null);
        }
        if(this.getLeft() != null){
            this.getLeft().removeNode(id);
        }

        if(this.getRight() != null && this.getRight().getId().equals(id)){
            this.setRight(null);
        }
        if(this.getRight() != null){
            this.getRight().removeNode(id);
        }
    }
}

@Data
@AllArgsConstructor
class HeroNodeTree {

    private HeroNode root;

    public void treePrefix() {
        root.prefix();
    }

    public void treeMid() {
        root.mid();
    }

    public void treeSuffix() {
        root.suffix();
    }

    public HeroNode treePrefixSearch(Integer id) {
        if (root == null) {
            System.out.println("空树，无需寻找");
            return null;
        }
        return root.prefixSearch(id);
    }

    public HeroNode treeMidSearch(Integer id) {
        if (root == null) {
            System.out.println("空树，无需寻找");
            return null;
        }
        return root.midSearch(id);
    }

    public HeroNode treeSuffixSearch(Integer id) {
        if (root == null) {
            System.out.println("空树，无需寻找");
            return null;
        }
        return root.suffixSearch(id);
    }

    public void treeRemoveNode(Integer id){
        if (root == null) {
            System.out.println("空树，无需寻找");
            return;
        }
        if(root.getId().equals(id)){
            System.out.println("root节点匹配，将其移除，成为空树");
            return;
        }
        root.removeNode(id);
    }

}