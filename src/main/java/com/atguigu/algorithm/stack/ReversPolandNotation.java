package com.atguigu.algorithm.stack;

import com.atguigu.algorithm.uitl.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 描述:
 * 逆波兰表达式解决计算起问题
 *
 * @author tong-aj
 * @create 2020-08-28 14:29
 */
public class ReversPolandNotation {

    private static final String ADD = "+";
    private static final String MINUS = "-";
    private static final String MULTI = "*";
    private static final String DIVIDE = "/";
    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public static void main(String[] args) {
        String expression = "21 + ( 2 + 3 ) * 4 - 5";
        // 转换中缀
        List<String> inSuffixExpression = toInSuffixExpression(expression);
        // 中缀转换后缀
        List<String> suffixExpression = toSuffixExpression(inSuffixExpression);
        int result = calculate(suffixExpression);
        System.out.println(result);
    }

    /**
     * 将表达式转为中缀列表
     *
     * @param expression
     * @return
     */
    public static List<String> toInSuffixExpression(String expression) {
        List<String> strings = Arrays.asList(expression.split(" "));
        return strings;
    }

    /**
     * 将中缀表达式列表转为后缀表达式列表
     *
     * @param expression
     * @return
     */
    public static List<String> toSuffixExpression(List<String> expression) {
        // 准备一个栈和一个列表
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        // 循环遍历入参
        for (String string : expression) {
            if (Util.isNumeric(string)) {
                // 如果是数字，直接压入list
                list.add(string);
            } else if (LEFT.equals(string)) {
                // 如果是"("，直接压入stack
                stack.push(string);
            } else if (RIGHT.equals(string)) {
                // 如果是")"，将stack中的符号依次压入list中，直到遇到"("
                while (!LEFT.equals(stack.peek())) {
                    list.add(stack.pop());
                }
                // 把剩下的"("也弹出
                stack.pop();
            } else if (isOperator(string)) {
                // 如果是操作符
                if (stack.isEmpty()) {
                    stack.push(string);
                } else if (priority(string) > priority(stack.peek())) {
                    // 优先级大于stack中栈顶的操作符，直接入栈
                    stack.push(string);
                } else {
                    // 小于等，则弹出stack栈顶的，压入list
                    list.add(stack.pop());
                    // 将操作符压入栈+
                    stack.push(string);
                }
            } else {
                throw new RuntimeException("中缀表达式有误");
            }
        }
        // 将stack中的元素全部压入list
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 接受逆波兰表达式数组
     *
     * @param expression
     * @return
     */
    public static int calculate(List<String> expression) {
        int result = 0;
        Stack<String> stack = new Stack<>();
        for (String string : expression) {
            // 如果是数字
            if (Util.isNumeric(string)) {
                // 直接入栈
                stack.push(string);
            } else {
                // 如果是操作符
                int number2 = Integer.valueOf(stack.pop());
                int number1 = Integer.valueOf(stack.pop());
                switch (string) {
                    case ADD:
                        result = number1 + number2;
                        break;
                    case MINUS:
                        result = number1 - number2;
                        break;
                    case MULTI:
                        result = number1 * number2;
                        break;
                    case DIVIDE:
                        result = number1 / number2;
                        break;
                    default:
                        System.out.println("输入操作符有误");
                        break;
                }
                // 将结果压入栈
                stack.push(String.valueOf(result));
            }
        }
        return result;
    }

    public static boolean isOperator(String operator) {
        return ADD.equals(operator) || MINUS.equals(operator) || MULTI.equals(operator) || DIVIDE.equals(operator);
    }

    public static int priority(String operator) {
        if (MULTI.equals(operator) || DIVIDE.equals(operator)) {
            return 1;
        } else if (ADD.equals(operator) || MINUS.equals(operator)) {
            return 0;
        } else {
            System.out.println("无视括号");
            return -1;
        }
    }
}
