package com.wyz.juc.c_001_sync_basics;

import com.wyz.util.SleepHelperUtil;

public class T00_01_WhatIsLock {
    private static Object o = new Object();

    public static void main(String[] args) {
        Runnable r = () -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + " start!");
                SleepHelperUtil.sleepSeconds(2);
                System.out.println(Thread.currentThread().getName() + " end!");
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(r).start();
        }
    }
}
