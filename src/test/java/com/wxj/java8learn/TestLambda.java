package com.wxj.java8learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxj.bean.Employee;
import com.wxj.service.MyPredicate;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 将list 转成 map
     */
    @Test
    public void  testListToMap(){
        Map<String,Employee> map = new HashMap<>();
        employees.forEach(employee -> {
            map.put(employee.getName(),employee);
        });

        Map<String, Employee> collect = employees.stream().collect(Collectors.toMap(Employee::getName, e -> e, (v1, v2) -> v1));

        System.out.println(map);

//        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(collect));

        String jsonString = JSON.toJSONString(map);

        System.out.println("xxxx:"+collect);
        System.out.println(jsonString);
    }

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

    @Test
    public void test6(){
        List<Employee> list = filterEmployees(employees,(e)-> e.getSalary() > 3000);
        list.forEach(System.out::println);
    }

    private List<Employee> filterEmployees(List<Employee> employees, MyPredicate<Employee> myPredicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e:employees) {
            if (myPredicate.test(e)){
                emps.add(e);
            }
        }
        return emps;
    }

}