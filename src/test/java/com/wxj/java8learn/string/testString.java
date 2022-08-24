package com.wxj.java8learn.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

public class testString {

    @Test
    public void testString(){
        String url = "http://dev-finance.sany.com.cn/client/muti1#/index";

        Optional<String> any = Arrays.stream(url.split("/")).filter(s -> s.contains("#")).findAny();
        String result = any.get().replace("#", "");
        System.out.println(result);


        String[] split = url.split("/");
        String s = split[split.length - 1];
        System.out.println(s);
    }
}
