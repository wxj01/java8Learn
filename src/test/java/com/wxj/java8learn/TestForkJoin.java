package com.wxj.java8learn;

import com.wxj.java8learn.forkjoin.ForkJoinCalculate;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/16 0016 16:38
 */
public class TestForkJoin {

    @Test
    public void test1(){
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);
        Long sum = forkJoinPool.invoke(task);

        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("消耗时间"+ Duration.between(start, end).toMillis()+"ms");

    }

    //直接使用java8的并行流
    @Test
    public void test2(){
        Instant start = Instant.now();
        LongStream.rangeClosed(0L,10000000000L)
                  .parallel()
                  .reduce(0,Long::sum);
    }
}