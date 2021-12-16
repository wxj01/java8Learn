package com.wxj.bean;

import lombok.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/15 0015 16:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private String name;
    private Integer age;
    private double salary;

    public Employee(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}