package com.mmall.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yejunyu
 * @date 18-3-19.
 */
public class test {

    public static void main(String[] args) {
        List<Object> a = Lists.newArrayList();
        Integer b = null;
        a.add(b);
        System.out.println(a);
    }
}
