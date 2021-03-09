package com.wyz.juc.c_018_00_AtomicXXX;

import com.wyz.util.SleepHelperUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T05_TestAtomicReference {

    private static class Student {
        String name;
        int age;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static Student chairman;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            final int j = i;
            new Thread(() -> {
                lock.lock();
                try {

                    chairman = new Student();
                    chairman.name = "s-" + j;
                    SleepHelperUtil.sleepMilli(1);
                    chairman.age = j;

                } finally {
                    lock.unlock();
                }
            }).start();
        }

        SleepHelperUtil.sleepSeconds(3);

        System.out.println(chairman);
    }
}
