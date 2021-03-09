package com.wyz.juc.c_000_threadbasic;

import com.wyz.util.SleepHelperUtil;

/**
 * interrupt与sleep() wait() join()
 */
public class T09_Interrupt_and_sync {

    private static Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                SleepHelperUtil.sleepSeconds(10);
            }
        });

        t1.start();

        SleepHelperUtil.sleepSeconds(1);

        Thread t2 = new Thread(() -> {
            synchronized (o) {

            }
            System.out.println("t2 end!");
        });

        t2.start();

        SleepHelperUtil.sleepSeconds(1);

        t2.interrupt();
    }
}
