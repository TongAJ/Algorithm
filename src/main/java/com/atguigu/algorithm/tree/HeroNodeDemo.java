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

        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode4);

        HeroNodeTree heroNodeTree = new HeroNodeTree(heroNode1);
        heroNodeTree.prefix();
        heroNodeTree.mid();
        heroNodeTree.suffix();


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
    
    // 三种遍历方式，前中后就是根节点的打印顺序

    /**
    * Description: 前序，先输出根节点，然后左子树，最后右子树
    * Param:
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void prefix(){
        System.out.println(this);
        if(this.getLeft() != null){
            this.getLeft().prefix();
        }
        if(this.getRight() != null){
            this.getRight().prefix();
        }
    }

    /**
    * Description: 中序，先输出左子树，然后根节点，最后右子树
    * Param:
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void mid(){
        if(this.getLeft() != null){
            this.getLeft().mid();
        }
        System.out.println(this);
        if(this.getRight() != null){
            this.getRight().mid();
        }
    }

    /**
    * Description: 后序遍历，先左子树，然后右子树，最后根节点
    * Param: [heroNode]
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void suffix(){
        if(this.getLeft() != null){
            this.getLeft().suffix();
        }
        if(this.getRight() != null){
            this.getRight().suffix();
        }
        System.out.println(this);
    }

    /**
    *
    * Description: 根据id进行节点的前序搜索
    * @author tongaijie
    * Param [id]
    * Return com.atguigu.algorithm.tree.HeroNode
    * Date 2020/11/2
    */    
    public HeroNode prefixSearch(Integer id){
        if(this.getId() == id){
            return this;
        } else {
            if( this.getLeft() != null){
                return  this.getLeft().prefixSearch(id);
            } else if ( this.getRight() != null){
                return  this.getRight().prefixSearch(id);
            }
        }
        return null;
    }

    /**
    *
    * Description: 根据id进行节点的中序搜索
    * @author tongaijie
    * Param [id]
    * Return com.atguigu.algorithm.tree.HeroNode
    * Date 2020/11/2
    */
    public HeroNode midSearch(Integer id){
        if(this.getId() == id){
            return this;
        } else {
            if( this.getLeft() != null){
                return  this.getLeft().midSearch(id);
            } else if ( this.getRight() != null){
                return  this.getRight().midSearch(id);
            }
        }
        return null;
    }
}

class HeroNodeTree{

    private HeroNode root;

    public HeroNodeTree(HeroNode root) {
        this.root = root;
    }

    /**
    * Description: 二叉树前序遍历
    * Param: []
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void prefix(){
        System.out.println("二叉树前序遍历");
        if(root != null){
            root.prefix();
        } else{
            System.out.println("二叉树根节点不能为空");
        }
    }

    /**
    * Description: 二叉树中序遍历
    * Param: []
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void mid(){
        System.out.println("二叉树中序遍历");
        if(root != null){
            root.mid();
        } else{
            System.out.println("二叉树根节点不能为空");
        }
    }

    /**
    * Description: 二叉树后序遍历
    * Param: []
    * return: void
    * Author: tongaijie
    * Date: 2020/11/2
    */
    public void suffix(){
        System.out.println("二叉树后序遍历");
        if(root != null){
            root.suffix();
        } else{
            System.out.println("二叉树根节点不能为空");
        }
    }


}