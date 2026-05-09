package com.kdjd.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 顺序处理
        long startTime = System.currentTimeMillis();
        List<Integer> sequentialResults = numbers.stream()
                .map(ParallelStreamExample::processNumber)
                .collect(Collectors.toList());
        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("顺序处理耗时: " + sequentialTime + "ms");

        // 并行处理
        startTime = System.currentTimeMillis();
        List<Integer> parallelResults = numbers.parallelStream()
                .map(ParallelStreamExample::processNumber)
                .collect(Collectors.toList());
        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("并行处理耗时: " + parallelTime + "ms");
        System.out.println("性能提升: " + (double) sequentialTime / parallelTime + "倍");
    }

    private static int processNumber(int number) {
        try {
            // 模拟耗时处理
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return number * number;
    }
}
