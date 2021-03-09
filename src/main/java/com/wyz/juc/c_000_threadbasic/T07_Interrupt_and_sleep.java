package com.wyz.juc.c_000_threadbasic;

import com.wyz.util.SleepHelperUtil;

/**
 * interrupt与sleep() wait() join()
 */
public class T07_Interrupt_and_sleep {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted!");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t.start();

        SleepHelperUtil.sleepSeconds(5);

        t.interrupt();
    }
}
