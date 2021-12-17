package com.wxj.java8learn;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/17 0017 8:57
 */
public class TestTime {
    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now(); //获取当前日期时间
        System.out.println(now);

        LocalDateTime of = LocalDateTime.of(2015, 10, 19, 13, 22, 33);//获取当前日期时间
        System.out.println(of);

        LocalDateTime localDateTime = now.plusYears(2); //加2年
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = now.minusMonths(2);//减2个月
        System.out.println(localDateTime1);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());


    }

    //2.Instant:时间戳（以Unix元年： 1970年1月1日00:00:00到某个时间之间的毫秒值）

    @Test
    public void test2(){
        Instant now = Instant.now();//获取偏移日期时间，加8小时偏移
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));//获取偏移日期时间，加8小时偏移
        System.out.println(offsetDateTime);

        System.out.println(now.toEpochMilli()); //获取与Unix元年间隔毫秒数

        Instant instant = Instant.ofEpochSecond(60);//较Unix元年加60秒
        System.out.println(instant);
    }


    //3.Duration:计算两个时间之间的间隔，Period：计算两个日期之间的间隔
    @Test
    public void test3(){
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());//1000


        System.out.println("-----------------------------");
        LocalTime now2 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        LocalTime now3 = LocalTime.now();
        System.out.println(Duration.between(now2,now3).toMillis());

        System.out.println("------------------------------");

        LocalDate ld1=LocalDate.of(2015, 1, 1);
        LocalDate ld2=LocalDate.now();
        Period period=Period.between(ld1, ld2);
        System.out.println(period.getYears());//6
        System.out.println(period.getMonths());//11
        System.out.println(period.getDays());//16
    }


    //TemporalAdjuster:时间校验器
    @Test
    public void test5(){
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);//

        LocalDateTime ldt2=ldt.withDayOfMonth(12);
        System.out.println(ldt2);//

        LocalDateTime ldt3=ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));//调整为下个周日
        System.out.println(ldt3);//

        //自定义：下一个工作日
        LocalDateTime ldt5=ldt.with((l)->{
            LocalDateTime ldt4=(LocalDateTime)l;
            DayOfWeek dow=ldt4.getDayOfWeek();//获取当前星期
            if(dow.equals(DayOfWeek.FRIDAY)){//如果是周5，下个工作日即加3天
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){//如果是周6，下个工作日即加2天
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);//其他，下个工作日即为明天
            }
        });
        System.out.println(ldt5);//
    }


    //DateTimeFormatter:格式化时间/日期
    @Test
    public void test6(){
        DateTimeFormatter dtf=DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt=LocalDateTime.now();

        String strDate=ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("------------------------");

        DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");//自定义格式化格式
//        DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//自定义格式化格式
        String strDate2=dtf2.format(ldt);
        System.out.println(strDate2);//2021年12月17日 09:24:06

        LocalDateTime newDate=ldt.parse(strDate2,dtf2);//以指定格式解析字符串，重新获得LocalDateTime类型
        System.out.println(newDate);//2021-12-17T09:24:06
    }

    //ZonedDate、ZonedTime、ZonedDateTime
    @Test
    public void test7(){
        Set<String> set=ZoneId.getAvailableZoneIds();//获取支持的所有时区
        set.forEach(System.out::println);

        LocalDateTime ldt=LocalDateTime.now(ZoneId.of("Europe/Monaco"));//获取指定时区的日期时间类型
        System.out.println(ldt);//2017-07-20T14:01:23.417

        LocalDateTime ldt2=LocalDateTime.now(ZoneId.of("Europe/Monaco"));
        ZonedDateTime zdt=ldt2.atZone(ZoneId.of("Europe/Monaco"));//获取带时区的时间类型
        System.out.println(zdt);//2021-12-17T02:28:59.457+01:00[Europe/Monaco]//与UTC时间有2个小时的时差
    }
}