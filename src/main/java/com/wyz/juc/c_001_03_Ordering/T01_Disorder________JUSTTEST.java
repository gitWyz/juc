package com.wyz.juc.c_001_03_Ordering;

import java.util.concurrent.CountDownLatch;

public class T01_Disorder________JUSTTEST {
    private static int x = 0, y = 0;

    public static void main(String[] args) {

        Thread other = new Thread(new Runnable() {
            public void run() {
                x = 1;
                y = 2;
            }
        });
        other.start();
    }

}