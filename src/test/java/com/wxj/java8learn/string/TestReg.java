package com.wxj.java8learn.string;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {

    @Test
    public void testRegReferer(){
//        http://billmill.org/bloomfilter-tutorial/
//        http://music.163.com/
        String referer1 = "http://billmill.org/bloomfilter-tutorial/";
        String referer2 = "  http://music.163.com/aaa";
        String referer3 = "  http://music.163.com/aaa/bbb";

        String reg = "[^/]+(?!.*/)";

        Pattern pattern = Pattern.compile(reg);

        Matcher matcher = pattern.matcher(referer1);
        if (matcher.find()){
            System.out.println("aaa");
            System.out.println(matcher.group());
        }


        Matcher matcher1 = pattern.matcher(referer2);
        boolean b = matcher1.find();
//        while (b){
//            System.out.println(matcher1.group());
//        }
        System.out.println(matcher1.group(0));

        Matcher matcher2 = pattern.matcher(referer3);
        if (matcher2.find()){
            System.out.println(matcher2.group());
        }



    }

}
