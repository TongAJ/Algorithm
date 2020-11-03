package com.atguigu.algorithm.stack;

import java.util.Arrays;

/**
 * 描述:
 * 数组模拟栈
 *
 * @author tong-aj
 * @create 2020-07-21 14:07
 */
public class SingleStack {

    private int[] stack;
    private int maxSize;
    private int top;

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "SingleStack{" +
                "stack=" + Arrays.toString(stack) +
                ", maxSize=" + maxSize +
                ", top=" + top +
                '}';
    }

    public SingleStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
        top = -1;
    }

    public boolean isFull(){
        return top == this.maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void list(){
        for (int i = top; i >=0 ; i--) {
            System.out.printf("展示数据为stack[%d]=%d\n",i,stack[i]);
        }
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈已满，无法执行入栈操作");
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空，无法执行出栈操作");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public static void main(String[] args) {
        SingleStack singleStack = new SingleStack(4);
        singleStack.push(1);
        singleStack.push(2);
        singleStack.push(3);
        singleStack.push(4);

        singleStack.list();

        singleStack.pop();
        singleStack.list();
    }
}
