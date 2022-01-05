package com.wxj.java8learn.stream.demo1;

import com.wxj.bean.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/16 0016 9:19
 */
public class TestStream {

    //创建Stream
    @Test
    public void test1(){
        //1.可以通过Collectino 系列集合提供的stream（）或者parallelStream（）
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.可以通过Arrays 中的静态方法stream（）获取数据流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        //3.可以通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4.创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}