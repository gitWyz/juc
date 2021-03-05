package com.wyz.thread;

/**
 * Test
 *
 * @author wangyz
 * @date 2021/3/5 15:49
 */
public class TestThread {

    public static void main(String[] args) {
        A a = new A();
        a.start();
    }

    static class A extends Thread {
        @Override
        public void run() {
            System.out.println("A.....");
        }
    }
}
