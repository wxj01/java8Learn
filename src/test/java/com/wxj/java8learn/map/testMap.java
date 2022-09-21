package com.wxj.java8learn.map;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class testMap {

    @Test
    public void testOrderMap(){
        Map<String, Integer> map = new HashMap<>();

        map.put("b",2);
        map.put("a",1);
        map.put("c",3);

        for (String key : map.keySet()){
            System.out.println(key +"--"+ map.get(key));
        }
    }

    @Test
    public void testLinkedHashMap(){
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("b",2);
        map.put("a",1);
        map.put("c",3);

        for (String key : map.keySet()){
            System.out.println(key +"--"+ map.get(key));
        }
    }

    @Test
    public void testTreeMap(){
        Map<String, Integer> map = new TreeMap<>();
        map.put("b",2);
        map.put("a",1);
        map.put("c",3);

        for (String key : map.keySet()){
            System.out.println(key +"--"+ map.get(key));
        }
    }
}
