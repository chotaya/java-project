package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiThreadCounterDemoTest {
    @Test
    void counterMatchesExpectedTotal() throws InterruptedException {
        int threadCount = 10;
        int incrementsPerThread = 500;
        int expected = threadCount * incrementsPerThread;

        int actual = MultiThreadCounterDemo.runCounterTest(threadCount, incrementsPerThread);

        assertEquals(expected, actual);
    }
}
