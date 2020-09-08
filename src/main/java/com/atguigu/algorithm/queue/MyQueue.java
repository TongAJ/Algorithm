package com.atguigu.algorithm.queue;

/**
 * 描述:
 *  队列的公共方法
 *
 * @author tony.w
 * @create 2020-05-31 16:15
 */
public interface MyQueue {

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断是否已满
     * @return
     */
    boolean isFull();

    /**
     * 新增元素
     * @param element
     */
    void addElement(int element);

    /**
     * 获取所有元素
     * @return
     */
    int getElement();

    /**
     * 获取第一个元素
     * @return
     */
    int getFrontElement();

    /**
     * 查询队列
     */
    void showQueue();
}
