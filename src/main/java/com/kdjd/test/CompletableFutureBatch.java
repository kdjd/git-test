package com.kdjd.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class CompletableFutureBatch {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
                "http://example.com/1", "http://example.com/2", "http://example.com/3",
                "http://example.com/4", "http://example.com/5", "http://example.com/6"
        );

        // 1. 批量获取网页内容
        List<String> contents = batchFetchUrls(urls);
        System.out.println("获取到 " + contents.size() + " 个网页内容");

        // 2. 并行处理并限制并发数
        processWithLimitedConcurrency(urls, 3);
    }

    // 批量并行获取URL内容
    private static List<String> batchFetchUrls(List<String> urls) {
        ExecutorService executor = Executors.newFixedThreadPool(
                Math.min(urls.size(), 10)  // 限制最大线程数
        );

        try {
            List<CompletableFuture<String>> futures = urls.stream()
                    .map(url -> CompletableFuture.supplyAsync(
                            () -> fetchUrl(url),
                            executor
                    ).exceptionally(ex -> {
                        System.err.println("获取URL失败: " + url + ", 错误: " + ex.getMessage());
                        return "错误内容";
                    }))
                    .collect(Collectors.toList());

            // 等待所有任务完成
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    futures.toArray(new CompletableFuture[0])
            );

            return allFutures.thenApply(v ->
                    futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList())
            ).join();
        } finally {
            executor.shutdown();
        }
    }

    // 限制并发数的处理方法
    private static void processWithLimitedConcurrency(List<String> items, int maxConcurrent) {
        ExecutorService executor = Executors.newFixedThreadPool(maxConcurrent);

        // 使用信号量控制并发数
        Semaphore semaphore = new Semaphore(maxConcurrent);

        List<CompletableFuture<Void>> futures = items.stream()
                .map(item -> CompletableFuture.runAsync(() -> {
                    try {
                        semaphore.acquire();
                        try {
                            processItem(item);
                        } finally {
                            semaphore.release();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }, executor))
                .collect(Collectors.toList());

        // 等待所有任务完成
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
        System.out.println("所有项目处理完成");
    }

    private static String fetchUrl(String url) {
        // 模拟网络请求
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "内容来自: " + url;
    }

    private static void processItem(String item) {
        // 模拟处理
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 处理了: " + item);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
