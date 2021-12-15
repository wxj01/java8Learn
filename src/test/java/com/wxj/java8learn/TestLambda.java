package com.wxj.java8learn;

import com.wxj.bean.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/15 0015 16:28
 */

public class TestLambda {

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> integers = new TreeSet<>(com);
    }

    //Lambda表达式
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> integers = new TreeSet<>(com);
    }


    List<Employee> employees = Arrays.asList(
            new Employee("张三",16,2000.1),
            new Employee("李四",17,3000.1),
            new Employee("王五",18,4000.1),
            new Employee("赵六",19,5000.1)
    );

    @Test
    public void test3(){
        //获取年龄大于17的
        List<Employee> emps = filterEmployees1(employees);
        for (Employee e:emps) {
            System.out.println(e);
        }

        //工资大于3000的
        List<Employee> emps2 = filterEmployees2(employees);
        for (Employee e: emps2) {
            System.out.println(e);
        }
    }

    private List<Employee> filterEmployees2(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e:employees) {
            if (e.getSalary() > 3000){
                emps.add(e);
            }
        }
        return emps;
    }

    private List<Employee> filterEmployees1(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e:employees) {
            if(e.getAge() > 17){
                emps.add(e);
            }
        }
        return emps;
    }


    //优化方式1：策略设计模式
    @Test
    public void test4(){
//        List<Employee> emps = filterEmployees(employees);
    }

}