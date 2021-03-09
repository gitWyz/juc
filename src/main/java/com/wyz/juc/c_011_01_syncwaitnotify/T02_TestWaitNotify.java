package com.wyz.juc.c_011_01_syncwaitnotify;

import com.wyz.util.SleepHelperUtil;

import java.util.concurrent.locks.LockSupport;

public class T02_TestWaitNotify {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("starting ...");
            SleepHelperUtil.sleepSeconds(1);
            LockSupport.park();
            System.out.println("end!");

        });

        t.start();

        SleepHelperUtil.sleepSeconds(5);

        LockSupport.unpark(t);

        //LockSupport.park(new Object());

    }
}
