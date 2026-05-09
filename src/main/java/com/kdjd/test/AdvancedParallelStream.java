package com.kdjd.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvancedParallelStream {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("item1", "item2", "item3", "item4", "item5");

        // 1. 并行流基本使用
        items.parallelStream()
                .forEach(item -> System.out.println(Thread.currentThread().getName() + ": " + item));

        // 2. 使用自定义线程池（避免使用公共线程池）
        ForkJoinPool customPool = new ForkJoinPool(4);
        customPool.submit(() ->
                items.parallelStream()
                        .forEach(item -> System.out.println("Custom pool: " + item))
        ).join();
        customPool.shutdown();

        // 3. 注意线程安全的收集操作
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        items.parallelStream()
                .forEach(item -> concurrentMap.put(item, item.length()));

        // 4. 使用 reduce 进行并行聚合
        int sum = IntStream.rangeClosed(1, 1000)
                .parallel()
                .reduce(0, Integer::sum);
        System.out.println("1-1000的和: " + sum);

        // 5. 过滤和映射组合
        List<String> processed = items.parallelStream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
