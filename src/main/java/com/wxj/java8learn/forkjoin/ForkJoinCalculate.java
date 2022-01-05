package com.wxj.java8learn.forkjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.RecursiveTask;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO ForkJoin
 * @date 2021/12/16 0016 16:32
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ForkJoinCalculate extends RecursiveTask<Long> {


    private long start;
    private long end;
    /**
     * @description: TODO 临界值
     * @author wangxinjian
     * @date 2022/1/5 0005 19:27
     * @version 1.0
     */
    private static final long THRESHOLD = 10000L;



    @Override
    protected Long compute() {
        long length = end -start;
        if (length <= THRESHOLD){
            long sum = 0;
            for (long i = start; i <= end ; i++) {
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end) /2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}