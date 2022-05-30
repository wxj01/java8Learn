package com.wxj.java8learn.stream;

import com.wxj.bean.Person;
import com.wxj.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName TestList2Map.java
 * @Description TODO
 * @createTime 2022年05月30日 22:01:00
 */

public class TestList2Map {

    @Test
    public void test(){
        List<User> list = new ArrayList<>();
        list.add(new User(1001, "小A"));
        list.add(new User(1002, "小B"));
        list.add(new User(1003, "小C"));
        list.add(new User(1003, "小D"));


        /**
         * java.lang.IllegalStateException: Duplicate key 小C
         *
         */
//        Map<Long, String> map = list.stream().collect(Collectors.toMap(User::getId, User::getName));
//        System.out.println(map);

//        Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName,(key1 , key2)-> key2 ));

        /**
         * a、key重复
         * 重复时用后面的value 覆盖前面的value
         */
        Map<Long, String> collect = list.stream()
                .collect(Collectors.toMap(User::getId, User::getName, (k1, k2) -> k2));
        System.out.println("collect:"+collect);

        /**
         * 重复时将前面的value 和后面的value拼接起来
         */
        Map<Long, String> collect1 = list.stream()
                .collect(Collectors.toMap(User::getId, User::getName, (k1, k2) -> k1.concat(k2)));
        System.out.println("collect1:"+collect1);


        /**
         * 重复时将重复key的数据组成集合
         */
        Map<Long, List<String>> map = list.stream().collect(Collectors.toMap(User::getId,
                p ->  {
                    List<String> getNameList = new ArrayList<>();
                    getNameList.add(p.getName());
                    return getNameList;
                },
                (List<String> value1, List<String> value2) -> {
                    value1.addAll(value2);
                    return value1;
                }
        ));
        System.out.println("map:"+map);


        /**
         * 在转换流中加上判空，即便value为空,依旧输出
         */
        list.add(new User(1004, null));
        Map<Long, List<String>> map2 = list.stream().collect(Collectors.toMap(User::getId,
                p ->  {
                    List<String> getNameList = new ArrayList<>();
                    getNameList.add(p.getName());
                    return getNameList;
                },
                (List<String> value1, List<String> value2) -> {
                    value1.addAll(value2);
                    return value1;
                }
        ));
        System.out.println("map2:"+map2);



    }

}
