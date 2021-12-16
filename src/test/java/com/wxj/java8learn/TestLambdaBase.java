package com.wxj.java8learn;

import com.wxj.service.MyFun;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO Lambda表达式的基础语法
 * @date 2021/12/16 0016 9:49
 */
public class TestLambdaBase {

    //语法格式一：无参数，无返回值
    //()->System.out.println(“Hello Lambda!”);
    @Test
    public void test1(){
        //通过匿名内部类的方式实现接口
        new Runnable(){
            @Override
            public void run() {
                System.out.println("hello world!!!");
            }
        }.run();

        System.out.println("----------------------------");

        //匿名内部类用代替匿名内部类
        Runnable r1 = () -> System.out.println("hello lambda");
        r1.run();
    }

    //语法格式二：有一个参数，并且无返回值
    //(x)->System.out.println(x);
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x); //对Consumer接口中有一个参数的accept方法的实现
        con.accept("啦啦啦");
    }

    //语法格式三：若只有一个参数，小括号可以不写
    //x->System.out.println(x);


    //语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    //语法格式五：若Lambda体中只有一条语句，大括号和 return 都可以省略不写
    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    }

    //语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断
    //(Integer x,Integer y)->Integer.compare(x,y);

    //左右遇一括号省
    //左侧推断类型省


    //对一个数进行运算
    @Test
    public void test6(){
      Integer num =  operation(100,(x) -> x*x);
        System.out.println(num);

        System.out.println(operation(200,(y)-> y+200));
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }

}