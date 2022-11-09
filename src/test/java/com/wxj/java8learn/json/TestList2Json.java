package com.wxj.java8learn.json;

import com.alibaba.fastjson.JSON;
import com.wxj.bean.Dog;
import com.wxj.bean.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList2Json {

    @Test
    public void testList2Json(){

        List<User> users = new ArrayList<>();

        User user1 = new User().setName("小明");
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog().setColor("白色").setKind("贵宾犬1"));
        dogs.add(new Dog().setColor("黄色").setKind("中华田园犬1"));
        dogs.add(new Dog().setColor("黑白").setKind("柯基1"));
        user1.setDogs(dogs);


        User user2 = new User().setName("小红");
        List<Dog> dogs2 = new ArrayList<>();
        dogs2.add(new Dog().setColor("白色").setKind("贵宾犬2"));
        dogs2.add(new Dog().setColor("黄色").setKind("中华田园犬2"));
        dogs2.add(new Dog().setColor("黑白").setKind("柯基2"));
        user2.setDogs(dogs2);

        User user3 = new User().setName("小王");
        List<Dog> dogs3 = new ArrayList<>();
        dogs3.add(new Dog().setColor("白色").setKind("贵宾犬3"));
        dogs3.add(new Dog().setColor("黄色").setKind("中华田园犬3"));
        dogs3.add(new Dog().setColor("黑白").setKind("柯基3"));
        user3.setDogs(dogs3);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println(users);

        System.out.println(JSON.toJSON(users));
    }
}
