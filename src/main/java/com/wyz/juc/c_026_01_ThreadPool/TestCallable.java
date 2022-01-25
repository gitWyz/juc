package com.wyz.juc.c_026_01_ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = new MyCallableTask();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Thread.sleep(100);
        /*Integer integer = futureTask.get();
        System.out.println(integer);*/
        futureTask.cancel(true);
        System.out.println("future is cancel: " + futureTask.isCancelled());
        if(!futureTask.isCancelled()) {
            System.out.println("future is cancelled");
        }
        System.out.println("future is done: " + futureTask.isDone());
        if(!futureTask.isDone()) {
            System.out.println("future get=" + futureTask.get());
        } else {
            //任务已完成
            System.out.println("task is done");
        }
    }
}
