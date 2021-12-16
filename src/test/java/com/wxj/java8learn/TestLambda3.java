package com.wxj.java8learn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/16 0016 10:27
 */
public class TestLambda3 {

    //Consumer<T> 消费型接口
    @Test
    public void test1(){
        happy(100,(m) -> System.out.println("喜欢大宝剑，消费："+m+"元"));
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //Supplier<T> 供给型接口:
    //需求：产生指定个数的整数，并放入集合中
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10,() -> (int)(Math.random()*100)+1);
        numList.forEach(System.out::println);

    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }

    //Function<T,R> 函数型接口:
    @Test
    public void test3(){
        String newStr = strHandler("\t\t\t 啦啦啦德玛西亚  ",(str) -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("无与伦比，为杰沉沦",(str) ->str.substring(5,9));
        System.out.println(subStr);
    }

    //处理字符串
    public String strHandler(String str , Function<String,String> fun){
        return fun.apply(str);
    }

    //Predicate<T> 断言型接口：
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello", "jj", "Lambda", "www", "ok");
        List<String> list1 = filterStr(list, (s) -> s.length() > 3);
        list1.forEach(System.out::println);
    }

    //将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String>list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String str:list) {
            if (pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}