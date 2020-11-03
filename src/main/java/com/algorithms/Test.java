package com.algorithms;

/**
 * 描述:
 *
 * @author tong-aj
 * 2020-09-14 13:52
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(gcd(10, 3));
    }

    /**
     * 查找两个数之间的最大公约数
     * @param p 第一个数字
     * @param q 第二个数字
     * @return 公约数
     */
    public static int gcd(int p, int q){
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r ) ;
    }


}
