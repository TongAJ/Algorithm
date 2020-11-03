package com.atguigu.algorithm.queue;

/**
 * 描述:
 * 线性数据：队列
 *      初步模拟队列
 *      问题：队列只能一次性
 * create 2020-05-30 22:32
 * @author tong-aj
 */
public class ArrayQueue extends AbstractQueue implements MyQueue{

    /**
     * ArrayQueue的构造函数
     * param arrayMaxSize
     */
    public ArrayQueue(int arrayMaxSize){
        this.setMaxSize(arrayMaxSize);
        this.setFront(-1);
        this.setRear(-1);
        this.setArray(new int[getMaxSize()]);
    }

    /**
     * 判断是否位空
     * return
     */
    @Override
    public boolean isEmpty(){
        return getFront() == getRear();
    }

    /**
     * 判断队列是否满
     */
    @Override
    public boolean isFull(){
        return getRear() == getMaxSize()-1;
    }

    /**
     * 添加数据
     * param element
     */
    @Override
    public void addElement(int element){
        // 判断是否满了
        if(isFull()){
            throw new RuntimeException("队列已满，无法添加");
        }
        setRear(getRear()+1);
        getArray()[getRear()] = element;
    }

    /**
     * 取出数据
     * return
     */
    @Override
    public int getElement(){
        // 判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        setFront(getFront()+1);
        return getArray()[getFront()];
    }

    /**
     * 获得头指针数据
      * return
     */
    @Override
    public int getFrontElement(){
        // 如果队列为空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return getArray()[getFront()+1];
    }

    @Override
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < getArray().length; i++) {
            System.out.println(getArray()[i] + " ");
        }
    }

    public static void main(String[] args) {
        new AbstractQueue().ScanQueue(new ArrayQueue(3));
    }

}
