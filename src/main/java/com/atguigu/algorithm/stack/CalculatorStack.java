package com.atguigu.algorithm.stack;

import com.atguigu.algorithm.uitl.Util;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 计算所使用的栈
 *
 * @author tong-aj
 * create 2020-07-21 15:27
 */
public class CalculatorStack {
    private String[] stack;
    private int maxSize;
    private int top;

    private static final String MULTI = "*";
    private static final String DIVIDE = "/";
    private static final String ADD = "+";
    private static final String MINUS = "-";

    public String[] getStack() {
        return stack;
    }

    public void setStack(String[] stack) {
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

    /**
     * 构造栈
     *
     * param maxSize
     */
    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new String[this.maxSize];
        top = -1;
    }

    /**
     * 栈是否满
     *
     * return
     */
    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    /**
     * 栈是否为空
     *
     * return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 展示栈中所有数据
     */
    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("展示数据为stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 入栈
     *
     * param value
     */
    public void push(String value) {
        if (isFull()) {
            System.out.println("栈已满，无法执行入栈操作");
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     *
     * return
     */
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法执行出栈操作");
        }
        String value = stack[top];
        stack[top] = null;
        top--;
        return value;
    }

    /**
     * 查看栈顶数据
     *
     * return
     */
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈为空，请先push数值");
        }
        return stack[top];
    }

    /**
     * 查询操作符优先级
     * 乘法和除法：1
     * 加法和减法：0
     *
     * param operator
     * return
     */
    public static int priority(String operator) {
        if (operator.equals(MULTI) || operator.equals(DIVIDE)) {
            return 1;
        } else if (operator.equals(ADD) || operator.equals(MINUS)) {
            return 0;
        } else {
            throw new RuntimeException("没有找到操作符对应的优先级");
        }
    }

    /**
     * 判断是否是操作符
     *
     * param operator
     * return
     */
    public static boolean isOperator(String operator) {
        return operator.equals(ADD) || operator.equals(MINUS) || operator.equals(MULTI) || operator.equals(DIVIDE);
    }

    /**
     * 根据操作符，进行两个数之间的操作
     *
     * param number1
     * param number2
     * param operator
     * return
     */
    public static int calculate(int number1, int number2, String operator) {
        switch (operator) {
            case ADD:
                return number1 + number2;
            case MINUS:
                return number2 - number1;
            case MULTI:
                return number1 * number2;
            case DIVIDE:
                return number2 / number1;
            default:
                throw new RuntimeException("操作符不规范");
        }
    }

    /**
     * 根据表达式，进行计算，返回结果
     *
     * param expression
     * return
     */
    public static int calculateResult(String expression) {
        // 1:定义数栈
        CalculatorStack numberStack = new CalculatorStack(10);
        // 2:定义操作符栈
        CalculatorStack operatorStack = new CalculatorStack(10);
        // 返回结果
        int result = 0;
        // 指针
        int index = 0;
        // 表达式长度
        int length = expression.length();
        // StringBuffer 存放多位数
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            // 获取index下标数据
            String current = expression.substring(index, index + 1);
            if (isOperator(current)) {
                // 是操作符
                // 判断操作符优先级
                if (!operatorStack.isEmpty()) {
                    if (priority(current) < priority(operatorStack.peek())) {
                        // 小于，进行计算
                        // 需要pop出数栈前两个数字，
                        // 和操作符栈的栈顶操作符，
                        // 然后将计算结果压入数栈
                        popNumberAndOperate(numberStack, operatorStack);
                    }
                }
                operatorStack.push(current);
            } else {
                // 是数字
                // 先将当前数字放入stringBuffer中
                stringBuffer.append(current);
                int temp = 1;
                while (true){
                    // 判断index+temp 是否小于length
                    if(index+temp < length ){
                        // 截取下一个字符串
                        current = expression.substring(index+temp,index+temp+1);
                        // 是否是数字
                        if(Util.isNumeric(current)){
                            // 是数字，存放在stringBuffer中
                            stringBuffer.append(current);
                            // temp+1
                            temp++;
                        }else {
                            // 不是数字则跳出循环
                            break;
                        }
                    }else {
                        // 已经到expression的最后一位，跳出循环
                        break;
                    }
                }
                // index赋值
                index = index + temp -1 ;
                // 将多位数压入数栈
                numberStack.push(stringBuffer.toString());
                // stringBuffer清空，准备下一位数字判断是否是多位数
                stringBuffer = new StringBuffer();
            }
            index++;
            if (index == expression.length()) {
                break;
            }
        }
        // 数字和操作符都压入栈后，开始进行计算
        while (true) {
            popNumberAndOperate(numberStack, operatorStack);
            if (numberStack.top == 0) {
                result = Integer.valueOf(numberStack.pop());
                break;
            }
        }
        return result;
    }

    /**
     * 将数栈pop出栈顶两个数，将操作符栈pop出栈顶的操作符，进行运算，并将结果push到数栈
     *
     * param numberStack
     * param operatorStack
     */
    private static void popNumberAndOperate(CalculatorStack numberStack, CalculatorStack operatorStack) {
        int number1 = Integer.valueOf(numberStack.pop());
        int number2 = Integer.valueOf(numberStack.pop());
        String operator = operatorStack.pop();
        int temp = calculate(number1, number2, operator);
        numberStack.push(String.valueOf(temp));
    }

    public static void main(String[] args) {
        int result = calculateResult("300+31*3-22");
        System.out.println(result);
    }
}
