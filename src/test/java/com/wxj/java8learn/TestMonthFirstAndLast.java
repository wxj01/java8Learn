package com.wxj.java8learn;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 获取某一个月的最后一天时间
 * @date 2021/12/21 0021 10:48
 */
public class TestMonthFirstAndLast {

    @Test
    public void test(){
        LocalDate date = LocalDate.parse("2021-02-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate first = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate last = date.with(TemporalAdjusters.lastDayOfMonth());
        long days = first.until(last, ChronoUnit.DAYS);
        System.out.println(days);

        String format = first.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(first.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(last.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}