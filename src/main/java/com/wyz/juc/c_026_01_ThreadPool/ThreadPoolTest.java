package com.wyz.juc.c_026_01_ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yzw
 */
public class ThreadPoolTest implements Runnable {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {
        try {
            Thread.sleep(300);
            //System.out.println("atomicInteger = " + atomicInteger.incrementAndGet());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 16; i++) {
            //threadPoolExecutor.execute(new ThreadPoolTest());
            threadPoolExecutor.execute(new Thread(new ThreadPoolTest(), "Thread".concat(i + "")));
            //threadPoolExecutor.execute(new ThreadPoolTest());
            System.out.println("线程中活跃的线程数" + threadPoolExecutor.getPoolSize());
            if (queue.size() > 0) {
                System.out.println("---------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPoolExecutor.shutdown();
    }
}
