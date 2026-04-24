package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadCounterDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 8;
        int incrementsPerThread = 1000;
        int finalCount = runCounterTest(threadCount, incrementsPerThread);

        System.out.println("Threads: " + threadCount);
        System.out.println("Increments per thread: " + incrementsPerThread);
        System.out.println("Expected count: " + (threadCount * incrementsPerThread));
        System.out.println("Actual count: " + finalCount);
    }

    public static int runCounterTest(int threadCount, int incrementsPerThread) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        AtomicInteger counter = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(threadCount);
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            tasks.add(() -> {
                try {
                    for (int j = 0; j < incrementsPerThread; j++) {
                        counter.incrementAndGet();
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        for (Runnable task : tasks) {
            executor.submit(task);
        }

        latch.await();
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        return counter.get();
    }
}
