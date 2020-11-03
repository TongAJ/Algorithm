package com.atguigu.algorithm.uitl;

import com.atguigu.algorithm.sort.MySort;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:
 * 工具类
 *
 * @author tong-aj
 * create 2020-08-25 21:10
 */
public class Util {

    /** 正则表达式：是否为数字 */
    private static Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * param str
     * return
     */
    public static boolean isNumeric(String str) {
        Matcher isNum = NUMBER_PATTERN.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static int[] testTimeCost(int number, MySort mySort) {
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = (int)(Math.random()*number);
        }
        long start = System.currentTimeMillis();
        mySort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return arr;
    }
}
