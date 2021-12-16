package com.wxj.java8learn;

import com.wxj.bean.Employee;
import com.wxj.bean.Status;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/16 0016 13:44
 */
public class TestStreamTerminate {

    List<Employee> employees= Arrays.asList(
            new Employee("张三",18,9999.99, Status.FREE),
            new Employee("李四",58,5555.55,Status.BUSY),
            new Employee("王五",26,3333.33,Status.VOCATION),
            new Employee("赵六",36,6666.66,Status.FREE),
            new Employee("田七",12,8888.88,Status.BUSY)
    );

    /*
     * 查找与匹配
     *
     */
    @Test
    public void test1(){
        boolean b1 = employees.stream() //allMatch 检查是否匹配所有元素
                .allMatch(employee -> employee.getStatus().equals(Status.BUSY));
        System.out.println(b1); //false

        boolean b2 = employees.stream() //anyMatch 检查是否至少匹配一个元素
                .anyMatch(employee -> employee.getStatus().equals(Status.BUSY));
        System.out.println(b2); //true

        boolean b3 = employees.stream() //noneMatch 检查是否没有匹配所有元素
                .noneMatch(employee -> employee.getStatus().equals(Status.BUSY));
        System.out.println(b3); //false

        Optional<Employee> op = employees.stream() //findFirst  返回第一个元素 Optional是Java8中避免空指针异常的容器类
                .sorted((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = employees.parallelStream() //findAny-返回当前流中的任意元素
                .filter(employee -> employee.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op2.get());

        long count = employees.stream() //count-返回流中元素的总个数
                .count();
        System.out.println(count);

        Optional<Employee> op3 = employees.stream() //max-返回流中最大值
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op3.get());


        Optional<Employee> op4 = employees.stream() //min-返回流中最小值
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op4.get());
    }


}