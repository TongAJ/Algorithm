package com.self.algorithm.tree.order;

import lombok.Data;
import lombok.ToString;

/**
 * Description: 重温线索化二叉树
 *
 * @author tong-aj
 *
 * Create: 2020-11-06 16:01
 */
@Data
public class OrderBinaryTree {

    private HeroNode root;

    private HeroNode pre;

    public void prefixThreadedNode(){

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



}