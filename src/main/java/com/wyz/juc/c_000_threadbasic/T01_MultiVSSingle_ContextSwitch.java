package com.wyz.juc.c_000_threadbasic;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.System.*;

public class T01_MultiVSSingle_ContextSwitch {

    private static final double[] NUMS = new double[10_0000_0000];
    private static final Random RANDOM = new Random();
    private static final DecimalFormat DF = new DecimalFormat("0.00");

    static {
        for (int i = 0; i < NUMS.length; i++) {
            NUMS[i] = RANDOM.nextDouble();
        }
    }

    private static void m1() {
        long start = currentTimeMillis();

        double result = 0.0;
        for (double num : NUMS) {
            result += num;
        }

        long end = currentTimeMillis();

        out.println("m1: " + (end - start) + " result = " + DF.format(result));
    }

    //=======================================================
    static double result1 = 0.0, result2 = 0.0, result = 0.0;

    private static void m2() throws Exception {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < NUMS.length / 2; i++) {
                result1 += NUMS[i];
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = NUMS.length / 2; i < NUMS.length; i++) {
                result2 += NUMS[i];
            }
        });

        long start = currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        result = result1 + result2;

        long end = currentTimeMillis();

        out.println("m2: " + (end - start) + " result = " + DF.format(result));
    }

    //===================================================================

    private static void m3() throws Exception {

        final int threadCount = 32;
        Thread[] threads = new Thread[threadCount];
        double[] results = new double[threadCount];
        final int segmentCount = NUMS.length / threadCount;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int m = i;

            threads[i] = new Thread(() -> {
                for (int j = m * segmentCount; j < (m + 1) * segmentCount && j < NUMS.length; j++) {
                    results[m] += NUMS[j];
                }
                latch.countDown();
            });

        }

        double resultM3 = 0.0;

        long start = currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }

        latch.await();
        for (int i = 0; i < results.length; i++) {
            resultM3 += results[i];
        }


        long end = currentTimeMillis();

        out.println("m3: " + (end - start) + " result = " + DF.format(result));
    }

    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
    }
}
