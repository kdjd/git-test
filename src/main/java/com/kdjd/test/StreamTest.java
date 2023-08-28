package com.kdjd.test;

import com.kdjd.json.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList<User>() {{
            add(new User("a", 1, 1L));
            add(new User("b", 2, 1L));
            add(new User("c", 3, 1L));
            add(new User("d", 4, 2L));
        }};
        list.forEach(StreamTest::print);

        List<String> collect3 = list.stream().map(user -> user.getDeptId().toString()).collect(Collectors.toList());
        System.out.println(String.join(",", collect3));

        //list to map key value 一对一
        Map<Integer, User> collect = list.stream().collect(Collectors.toMap(User::getAge, Function.identity()));
        System.out.println(collect);

        // 过滤
        List<User> collect1 = list.stream().filter(user -> user.getAge() == 2).collect(Collectors.toList());
        System.out.println(collect1);

        Map<Long, List<User>> collect2 = list.stream().collect(Collectors.groupingBy(User::getDeptId));
        System.out.println(collect2);

        list = new ArrayList<>();
        list.forEach(StreamTest::print);

        System.out.println(new Date());
    }

    private static void print(User user) {
        System.out.println(user.toString());
    }
}
