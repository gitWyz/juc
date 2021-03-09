package com.wyz.juc.c_001_00_thread_end;

import com.wyz.util.SleepHelperUtil;

public class T02_Suspend_Resume {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("go on");
                SleepHelperUtil.sleepSeconds(1);
            }
        });

        t.start();

        SleepHelperUtil.sleepSeconds(5);

        t.suspend();
        SleepHelperUtil.sleepSeconds(3);
        t.resume();

    }
}
