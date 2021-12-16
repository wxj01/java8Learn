package com.wxj.service.impl;

import com.wxj.bean.Employee;
import com.wxj.service.MyPredicate;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/16 0016 9:44
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 3000;
    }
}