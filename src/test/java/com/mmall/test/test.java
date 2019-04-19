package com.mmall.test;

import com.mmall.common.ResponseCode;

import java.util.Arrays;

/**
 * @author yejunyu
 * @date 18-3-19.
 */
public class test {
    int i ;

    String name;
    public static void main(String[] args) {
        BigDecimalTest bigDecimalTest = new BigDecimalTest();
        test test = new test();
        System.out.println(test.i+test.name);
        System.out.println(Arrays.toString(ResponseCode.values()));
    }
}


