package com.atguigu.algorithm.queue;


/**
 * 描述:
 * 队列：环形队列，解决队列可重复问题
 *
 * @create 2020-05-31 16:10
 * @author tong-aj
 */
public class CircleQueue extends AbstractQueue implements MyQueue {

    public static void main(String[] args) {
        new AbstractQueue().ScanQueue(new CircleQueue(4));
    }

    public CircleQueue(int maxSize){
        setMaxSize(maxSize);
        setArray(new int[getMaxSize()]);
    }

    @Override
    public boolean isEmpty() {
        return getFront()==getRear();
    }

    @Override
    public boolean isFull() {
        return (getRear()+1) % getMaxSize() == getFront();
    }

    @Override
    public void addElement(int element) {
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        getArray()[getRear()] = element;
        setRear((getRear()+1) % getMaxSize());
    }

    @Override
    public int getElement() {
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value = getArray()[getFront()];
        setFront((getFront()+1) % getMaxSize());
        return value;
    }

    @Override
    public int getFrontElement() {
        return getArray()[getFront()];
    }

    @Override
    public void showQueue() {
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = getFront(); i < (getFront()+(getRear()-getFront()+getMaxSize()) % getMaxSize()); i++) {
            System.out.printf("arr[%d]=%d\n", i % getMaxSize(), getArray()[i % getMaxSize()]);
        }
    }

}
