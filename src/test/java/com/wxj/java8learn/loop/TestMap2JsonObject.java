package com.wxj.java8learn.loop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMap2JsonObject {

    @Test
    public void testMap2JsonObject(){
        Map<String, Integer> map = new HashMap<>();
        map.put("b",2);
        map.put("a",1);
        map.put("c",3);

        System.out.println("map = " + map);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(map));

        System.out.println("jsonObject = " + jsonObject);

        JSONObject json = (JSONObject) JSON.toJSON(map);
        System.out.println("json = " + json);
        json.put("d",4);
        System.out.println("json = " + json);
    }
}
