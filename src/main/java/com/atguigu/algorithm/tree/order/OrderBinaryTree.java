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

    // 三种遍历方式，前中后就是根节点的打印顺序

    /**
     * Description: 前序，先输出根节点，然后左子树，最后右子树
     * Param:
     * return: void
     * Author: tong-aj
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
     * Author: tong-aj
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
     * Author: tong-aj
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
     * @author tong-aj
     * Param [id]
     * Return HeroNode
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
     * @author tong-aj
     * Param [id]
     * Return HeroNode
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
     * return: HeroNode
     * Author: tong-aj
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
     * Author: tong-aj
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

    /**
     * Description: 根据一定的规则进行节点的删除，
     * 当删除节点为非叶子节点时，
     * 如果只有一个子节点，则使用该子节点替换被删除节点
     * 如果左、右子节点都有值。则使用左子节点替代该被删除的节点
     * Param: [heroNode]
     * return: void
     * Author: tong-aj
     * Date: 2020/11/3
     */
    public void removeInRule(Integer id) {
        // 当左子节点匹配时
        if (this.getLeft() != null && this.getLeft().getId().equals(id)) {
            //  判断该节点下是一个节点还是有两个节点
            //  1:有两个节点时
            if (this.getLeft().getLeft() != null && this.getLeft().getRight() != null) {
                // 先将匹配节点的右子节点配置到匹配节点的左子节点下
                this.getLeft().getLeft().setLeft(this.getLeft().getRight());
                // 用匹配节点的左子节点替代自己
                this.setLeft(this.getLeft().getLeft());
            } else {
                // 匹配的节点的左子节点不为空，也同时表示匹配节点的右子节点为空
                if (this.getLeft().getLeft() != null) {
                    this.setLeft(this.getLeft().getLeft());
                } else if (this.getLeft().getRight() != null) {
                    this.setLeft(this.getLeft().getRight());
                }
            }
        }
        // 当右子节点匹配时
        if (this.getRight() != null && this.getRight().getId().equals(id)) {
            // 同上逻辑
            //  判断该节点下是一个节点还是有两个节点
            //  1:有两个节点时
            if (this.getRight().getLeft() != null && this.getRight().getRight() != null) {
                // 先将匹配节点的右子节点配置到匹配节点的左子节点下
                this.getRight().getLeft().setLeft(this.getRight().getRight());
                // 用匹配节点的左子节点替代自己
                this.setRight(this.getRight().getLeft());
            } else {
                // 匹配的节点的左子节点不为空，也同时表示匹配节点的右子节点为空
                if (this.getRight().getLeft() != null) {
                    this.setRight(this.getRight().getLeft());
                } else if (this.getRight().getRight() != null) {
                    this.setRight(this.getRight().getRight());
                }
            }
        }
        // 没有匹配到时
        // 先向左侧进行递归删除
        if (this.getLeft() != null) {
            this.getLeft().removeInRule(id);
        }
        if (this.getRight() != null) {
            this.getRight().removeInRule(id);
        }
    }


}
