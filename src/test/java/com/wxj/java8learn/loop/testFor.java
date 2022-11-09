package com.wxj.java8learn.loop;

import org.junit.jupiter.api.Test;

public class testFor {

    @Test
    public void testFor(){

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 3){
                return;
            }
        }
        System.out.println("is over");
    }
}
