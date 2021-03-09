package com.wyz.juc.c_000_threadbasic;

import com.wyz.util.SleepHelperUtil;

import static java.lang.System.*;

/**
 * 什么是线程
 * @author mi
 */
public class T00WhatIsThread {
    private static final int SIZE = 10;

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < SIZE; i++) {
                SleepHelperUtil.sleepSeconds(1);
                out.println("T1");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //new T1().run();
        new T1().start();
        for (int i = 0; i < SIZE; i++) {
            SleepHelperUtil.sleepSeconds(1);
            out.println("--main");
        }

        SleepHelperUtil.sleepSeconds(1);
    }
}
