package com.wxj.java8learn.iface;

import com.wxj.service.MyFunc2;
import com.wxj.service.Named;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/17 0017 8:49
 */
public class MyClass implements MyFunc2, Named {
    @Override
    public String getName() {
        return MyFunc2.super.getName();
    }
}