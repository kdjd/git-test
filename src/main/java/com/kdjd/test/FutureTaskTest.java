package com.kdjd.test;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) {
        List<FutureTask<List<String>>> taskList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            FutureTask<List<String>> futureTask = new FutureTask<>(() -> {
                List<String> beanList = new ArrayList<>();
                beanList.add(String.valueOf(finalI));
                try {
                    Thread.sleep(RandomUtils.nextInt(1, 100));
                } catch (Exception ignored) {
                }
                return beanList;
            });
            taskList.add(futureTask);
            executor.submit(futureTask);
        }
        boolean flag = true;
        while (flag) {
            if (CollectionUtils.isEmpty(taskList)) {
                flag = false;
            }
            Iterator<FutureTask<List<String>>> iterator = taskList.iterator();
            while (iterator.hasNext()) {
                FutureTask<List<String>> next = iterator.next();
                if (next.isDone() && !next.isCancelled()) {
                    try {
                        for (String s : next.get()) {
                            System.out.println(s);
                        }
                        iterator.remove();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }


    }


}
