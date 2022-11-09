package com.wxj.java8learn.someother;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSome {

    @Test
    public void testSome(){

        List<String> sources = new ArrayList<>();

        String string = getString(sources, "1");

        System.out.println("sources = " + sources);

    }

    private String getString( List<String> sources,String relationId){
        sources.add("1");
        return "2";

    }
}
