package com.wxj.java8learn.stream.demo2;

import com.wxj.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/5 0005 19:31
 */
public class TestStream {



    public static List<Person> getPersonList(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        return personList;
    }


    /**
     * @description: TODO 遍历/匹配（foreach/find/match）
     * @author wangxinjian
     * @date 2022/1/5 0005 19:44
     * @version 1.0
     */
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        //遍历输出符合条件的元素
        list.stream().filter(x -> x > 5).forEach(System.out::println);

        //匹配第一个
        Optional<Integer> first = list.stream().filter(x -> x > 5).findFirst();
        //匹配任何一个
        Optional<Integer> any = list.stream().filter(x -> x > 5).findAny();
        //是否包含符合条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 5);
        System.out.println("匹配第一个值：" + first.get());
        System.out.println("匹配任意一个值：" + any.get());
        System.out.println("是否存在大于5的值：" + anyMatch);

    }

    /**
     * @description: TODO  筛选（filter）
     * @author wangxinjian
     * @date 2022/1/5 0005 19:44
     * @version 1.0
     */
    @Test
    public void test2(){
        List<Person> personList = getPersonList();
        List<String> list = personList.stream().filter(x -> x.getSalary() > 8000)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("高于8000的员工："+list);
    }

    /**
     * @description: TODO 聚合（max/min/count)
     * @author wangxinjian
     * @date 2022/1/5 0005 19:44
     * @version 1.0
     */
    @Test
    public void test3(){
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串："+max.get());

    }

    /**
     * @description: TODO 聚合（max/min/count)
     * @author wangxinjian
     * @date 2022/1/5 0005 19:46
     * @version 1.0
     */
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        //自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);

        //自定义排序
        Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("自然排序的最大值："+max.get());
        System.out.println("自定义的最大值："+max2.get());
    }

    /**
     * @description: TODO 获取员工工资最高的人
     * @author wangxinjian
     * @date 2022/1/5 0005 19:54
     * @version 1.0
     */
    @Test
    public void test5(){
        List<Person> personList = getPersonList();
        Optional<Person> max = personList.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println("员工工资最大值："+ max.get().getSalary());
    }

    /**
     * @description: TODO 计算Integer集合中大于6的元素的个数
     * @author wangxinjian
     * @date 2022/1/5 0005 20:02
     * @version 1.0
     */
    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);

        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数"+ count);
    }

    /**
     * @description: TODO 映射(map/flatMap)
     * @author wangxinjian
     * @date 2022/1/5 0005 20:03
     * @version 1.0
     */
    @Test
    public void test7(){
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };

        List<String> collect = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);

        List<Integer> integerList = intList.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("每个元素大写："+ collect);
        System.out.println("每个元素+3:"+integerList);
    }

    @Test
    public void test8(){
        List<Person> personList = getPersonList();
        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());

        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        //改变原来员工集合的方式
        List<Person> personListNew2 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 10000);
            return person;
        }).collect(Collectors.toList());

        System.out.println("二次改动前：" + personList.get(0).getName() + "-->" + personListNew.get(0).getSalary());
        System.out.println("二次改动后：" + personListNew2.get(0).getName() + "-->" + personListNew.get(0).getSalary());

    }

    /**
     * @description: TODO 将两个字符数组合并成一个新的字符数组
     * @author wangxinjian
     * @date 2022/1/5 0005 20:14
     * @version 1.0
     */
    @Test
    public void test9(){
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> list2 = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合："+list);
        System.out.println("处理后的集合："+list2);
    }
   
    /**
     * @description: TODO 规约（reduce）
     * @author wangxinjian
     * @date 2022/1/5 0005 20:26
     * @version 1.0
     */
    @Test
    public void test10(){
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        //求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        //求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        //求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        //求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        //求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        //求最大值方式2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max.get() + "," + max2);

    }

    /**
     * @description: TODO 求所有员工的工资之和和最高工资
     * @author wangxinjian
     * @date 2022/1/5 0005 20:32
     * @version 1.0
     */
    @Test
    public void test11(){
        List<Person> personList = getPersonList();
        // 求工资之和方式1：
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                (sum1, sum2) -> sum1 + sum2);
        // 求工资之和方式3：
        Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        // 求最高工资方式1：
        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);

        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);
    }

    /**
     * @description: TODO 收集(collect) 归集(toList/toSet/toMap)
     * @author wangxinjian
     * @date 2022/1/6 0006 9:07
     * @version 1.0
     */
    @Test
    public void test12(){
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        List<Person> personList = getPersonList();
        Map<String, Person> map = personList.stream().filter(p -> p.getSalary() > 8000)
                .collect(Collectors.toMap(Person::getName, p -> p));

        System.out.println("toList:" + listNew);
        System.out.println("toSet:" + set);
        System.out.println("toMap:" + map);

    }

    /**
     * @description: TODO 统计(count/averaging)
     * @author wangxinjian
     * @date 2022/1/6 0006 9:11
     * @version 1.0
     */
    @Test
    public void test13(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        //求人数总和
        Long count = personList.stream().collect(Collectors.counting());
        //求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        //求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compareTo));
        //最高工资2
        Optional<Person> max2 = personList.stream().collect(Collectors.maxBy((p1, p2) -> Integer.compare(p1.getSalary(), p2.getSalary())));
        //求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        //员工工资所有统计
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));


        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工max工资：" + max.get());
        System.out.println("员工max2工资：" + max2.get().getSalary());
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);


    }

    /**
     * @description: TODO 分组(partitioningBy/groupingBy)
     * @author wangxinjian
     * @date 2022/1/6 0006 9:32
     * @version 1.0
     */
    @Test
    public void test14(){
        List<Person> personList = getPersonList();

        //将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        //将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        //将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);

    }

    /**
     * @description: TODO 接合(joining)
     * @author wangxinjian
     * @date 2022/1/6 0006 9:42
     * @version 1.0
     */
    @Test
    public void test15(){
        List<Person> personList = getPersonList();
        String names = personList.stream().map(Person::getName).collect(Collectors.joining("<*>"));
        System.out.println("所有员工的姓名:"+names);

        List<String> list = Arrays.asList("A", "B", "C");
        String string = list.stream().collect(Collectors.joining("$"));
        System.out.println("拼接后的字符串：" + string);
    }

    /**
     * @description: TODO 归约(reducing)
     * @author wangxinjian
     * @date 2022/1/6 0006 9:47
     * @version 1.0
     */
    @Test
    public void test16(){
        List<Person> personList = getPersonList();

        // 每个员工减去起征点后的薪资之和（这个例子并不严谨，但一时没想到好的例子）
        Optional<Integer> reduce = personList.stream().map(person -> person.getSalary() - 5000).reduce(Integer::sum);
        System.out.println("员工扣税薪资总和：" + reduce.get());


        Integer sum = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("员工扣税薪资总和：" + sum);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());

    }

    /**
     * @description: TODO  排序(sorted)
     * @author wangxinjian
     * @date 2022/1/6 0006 10:05
     * @version 1.0
     */
    @Test
    public void test17(){
        List<Person> personList = getPersonList();
        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .map(Person::getName)
                .collect(Collectors.toList());

        // 按工资倒序排序
        List<String> newList2 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName)
                .collect(Collectors.toList());

        //先按工资再按年龄升序
        List<String> newList3 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary)
                        .thenComparing(Person::getAge))
//                .sorted(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .collect(Collectors.toList());

        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p2.getSalary();
            }
        }).map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("按工资升序排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
        System.out.println("先按工资再按年龄升序排序：" + newList3);
        System.out.println("先按工资再按年龄自定义降序排序：" + newList4);


    }

    /**
     * @description: TODO 提取/组合
     * @author wangxinjian
     * @date 2022/1/6 0006 10:22
     * @version 1.0
     */
    @Test
    public void test18(){
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);

        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());

        // skip：跳过前n个数据
        List<Integer> collect1 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect1);

    }

}