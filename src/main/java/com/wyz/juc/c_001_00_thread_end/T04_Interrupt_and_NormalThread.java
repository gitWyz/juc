package com.wyz.juc.c_001_00_thread_end;

import com.wyz.util.SleepHelperUtil;

/**
 * interrupt是设定标志位
 */
public class T04_Interrupt_and_NormalThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                //sleep wait
            }

            System.out.println("t1 end!");
        });

        t.start();

        SleepHelperUtil.sleepSeconds(1);

        t.interrupt();

    }
}
