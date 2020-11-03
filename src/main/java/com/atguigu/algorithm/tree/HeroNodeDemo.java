package com.atguigu.algorithm.tree;

import lombok.Data;
import lombok.ToString;

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
        System.out.println();

        System.out.println("开始前序查找");
        System.out.println(heroNodeTree.prefixSearch(5));
        System.out.println();

        System.out.println("开始中序查找");
        System.out.println(heroNodeTree.midSearch(5));
        System.out.println();

        System.out.println("开始后序查找");
        System.out.println(heroNodeTree.suffixSearch(5));
        System.out.println();


        heroNodeTree.removeNode(4);
        if (heroNodeTree.getRoot() != null) {
            heroNodeTree.prefix();
        } else {
            System.out.println("该二叉树已经为空树");
        }

    }

}

/**
 * 树节点
 */
@Data
@ToString
class HeroNode {

    private Integer id;
    private String name;
    @ToString.Exclude
    private HeroNode left;
    @ToString.Exclude
    private HeroNode right;

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
    public void prefix() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().prefix();
        }
        if (this.getRight() != null) {
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
    public void mid() {
        if (this.getLeft() != null) {
            this.getLeft().mid();
        }
        System.out.println(this);
        if (this.getRight() != null) {
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
    public void suffix() {
        if (this.getLeft() != null) {
            this.getLeft().suffix();
        }
        if (this.getRight() != null) {
            this.getRight().suffix();
        }
        System.out.println(this);
    }

    /**
     * Description: 根据id进行节点的前序搜索
     *
     * @author tongaijie
     * Param [id]
     * Return com.atguigu.algorithm.tree.HeroNode
     * Date 2020/11/2
     */
    public HeroNode prefixSearch(Integer id) {
        // 判断当前节点是否匹配
        if (this.getId().equals(id)) {
            // 匹配直接返回
            return this;
        }
        System.out.println("当前节点：" + this + "，没有找到");
        // 如果当前不匹配，定义一个结果变量
        HeroNode result = null;
        // 左子节点不为空
        if (this.getLeft() != null) {
            // 进行递归左侧前序搜索
            result = this.getLeft().prefixSearch(id);
        }
        // 如果找到了，直接返回
        if (result != null) {
            return result;
        }
        // 如果左子树都没找到，去右子树找
        if (this.getRight() != null) {
            result = this.getRight().prefixSearch(id);
        }
        // 不管找没找到，都返回result
        return result;
    }

    /**
     * Description: 根据id进行节点的中序搜索
     *
     * @author tongaijie
     * Param [id]
     * Return com.atguigu.algorithm.tree.HeroNode
     * Date 2020/11/2
     */
    public HeroNode midSearch(Integer id) {
        // 定义一个结果变量
        HeroNode result = null;
        // 左子节点不为空
        if (this.getLeft() != null) {
            // 进行递归左侧前序搜索
            result = this.getLeft().midSearch(id);
        }
        // 如果变量有值，说明找到了，直接返回
        if (result != null) {
            return result;
        }
        // 判断当前节点是否匹配
        if (this.getId().equals(id)) {
            // 匹配直接返回
            return this;
        }
        System.out.println("当前节点：" + this + "，没有找到");
        // 如果左子树都没找到，去右子树找
        if (this.getRight() != null) {
            result = this.getRight().midSearch(id);
        }
        // 不管找没找到，都返回result
        return result;
    }

    /**
     * Description: 根据id进行后序搜索
     * Param: [id]
     * return: com.atguigu.algorithm.tree.HeroNode
     * Author: tongaijie
     * Date: 2020/11/3
     */
    public HeroNode suffixSearch(Integer id) {
        // 定义变量
        HeroNode result = null;
        // 如果左子树不为空
        if (this.getLeft() != null) {
            // 向左进行后序搜索
            result = this.getLeft().suffixSearch(id);
        }
        // 判断变量是否为空
        if (result != null) {
            // 找到节点
            return result;
        }
        // 如果右子树不为空
        if (this.getRight() != null) {
            // 向右进行后序搜索
            result = this.getRight().suffixSearch(id);
        }
        // 如果变量不为空
        if (result != null) {
            // 找到节点
            return result;
        }
        // 判断是否匹配
        if (this.getId().equals(id)) {
            // 匹配则直接返回
            return this;
        }
        System.out.println("当前节点：" + this + "，没有找到");
        // 都没周到，返回null
        return null;
    }

    /**
     * Description: 根据id进行删除节点,叶子节点直接删除，非叶子节点，将该节点下的节点全部删除
     * Param: [id]
     * return: void
     * Author: tongaijie
     * Date: 2020/11/3
     */
    public void removeNode(Integer id) {
        // 如果该节点的左子节点匹配
        if (this.getLeft() != null && this.getLeft().getId().equals(id)) {
            // 左子节点删除
            this.setLeft(null);
            return;
        }
        // 如果节点的右子节点匹配
        if (this.getRight() != null && this.getRight().getId().equals(id)) {
            // 右子节点删除
            this.setRight(null);
            return;
        }
        // 查找左子节点是否为空
        if (this.getLeft() != null) {
            // 不为空则向左侧进行递归删除
            this.getLeft().removeNode(id);
        }
        // 查找右子节点是否为空
        if (this.getRight() != null) {
            // 不为空则向右侧进行递归删除
            this.getRight().removeNode(id);
        }

    }
}

@Data
class HeroNodeTree {

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
    public void prefix() {
        System.out.println("二叉树前序遍历");
        if (root != null) {
            root.prefix();
        } else {
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
    public void mid() {
        System.out.println("二叉树中序遍历");
        if (root != null) {
            root.mid();
        } else {
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
    public void suffix() {
        System.out.println("二叉树后序遍历");
        if (root != null) {
            root.suffix();
        } else {
            System.out.println("二叉树根节点不能为空");
        }
    }

    /**
     * Description: 根据id对二叉树进行前序搜索
     * Param: [id]
     * return: com.atguigu.algorithm.tree.HeroNode
     * Author: tongaijie
     * Date: 2020/11/3
     */
    public HeroNode prefixSearch(Integer id) {
        // 如果根节点为空，直接返回
        if (root == null) {
            System.out.println("根节点为空，无法搜索");
            return null;
        }
        return root.prefixSearch(id);
    }

    /**
     * Description: 根据id进行二叉树的中序查询
     * Param: [id]
     * return: com.atguigu.algorithm.tree.HeroNode
     * Author: tongaijie
     * Date: 2020/11/3
     */
    public HeroNode midSearch(Integer id) {
        // 如果根节点为空，直接返回
        if (root == null) {
            System.out.println("根节点为空，无法搜索");
            return null;
        }
        return root.midSearch(id);
    }

    /**
     * Description: 根据id进行二叉树的后序搜索
     * Param: [id]
     * return: com.atguigu.algorithm.tree.HeroNode
     * Author: tongaijie
     * Date: 2020/11/3
     */
    public HeroNode suffixSearch(Integer id) {
        // 如果根节点为空，直接返回
        if (root == null) {
            System.out.println("根节点为空，无法搜索");
            return null;
        }
        return root.suffixSearch(id);
    }

    /**
     * Description: 根据id进行二叉树删除对应的节点
     * Param: [id]
     * return: void
     * Author: tongaijie
     * Date: 2020/11/3
     */
    public void removeNode(Integer id) {
        if (root.getId().equals(id)) {
            root = null;
            System.out.println("根节点为空，清除二叉树");
            return;
        }
        root.removeNode(id);
    }
}