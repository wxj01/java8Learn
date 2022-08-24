package com.wxj.java8learn;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map<String, String[] 转成 Map<String, Object>
 * 测试map
 */
public class TestMapLambda {


    @Test
    public void test() {
        Map<String, String[]> map = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        map.forEach((k, v) -> resultMap.put(k, v[0]));

    }
}
