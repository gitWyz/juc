package com.wyz.juc.c_000_threadbasic;

import com.wyz.util.SleepHelperUtil;

/**
 * interrupt()与isInterrupted()
 * 设置标志位 + 查询标志位
 */
public class T05_Interrupt_and_isInterrupted {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (; ; ) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });

        t.start();

        SleepHelperUtil.sleepSeconds(2);

        t.interrupt();
    }
}
