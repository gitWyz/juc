package com.wyz.juc.c_026_01_ThreadPool;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallableTask implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("callable do something");
        Thread.sleep(5000);
        return new Random().nextInt(100);
    }
}
