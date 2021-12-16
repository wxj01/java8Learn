package com.wxj.java8learn;

import com.wxj.bean.Employee;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/16 0016 10:45
 */
public class TestMethodRef {

    //对象::实例方法名
    @Test
    public void test1(){
        PrintStream ps1 = System.out;
        Consumer<String> con = (x) -> ps1.println(x); //生成了一个实现了Consumer接口的类的对象

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;//相当于上面，引用了ps对象的println()方法

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    @Test
    public void test2(){
        Employee employee = new Employee();
        Supplier<String> sup = () -> employee.getName();//代替匿名内部类
        String s = sup.get();
        System.out.println(s);

        Supplier<Integer> sup2 = employee::getAge;
        Integer integer = sup2.get();
        System.out.println(integer);
    }


    //类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;
    }

    //类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);
        BiPredicate<String,String> bp2 = String::equals;
    }


    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new; //使用无参构造器
        Employee employee = sup2.get();
        System.out.println(employee);

        Function<Integer,Employee> fun2 = (x) ->new Employee(x);
        Employee apply = fun2.apply(101);
        System.out.println(apply);

        BiFunction<String,Integer,Employee> bf = Employee::new;
    }

    //数组引用
    @Test
    public void test6(){
        Function<Integer,String[]> fun = (x) -> new String[x];
        String[] apply = fun.apply(10);
        System.out.println(apply.length);

        Function<Integer,String[]> fun2 = String[]::new;
        String[] apply1 = fun2.apply(20);
        System.out.println(apply1.length);
    }

}