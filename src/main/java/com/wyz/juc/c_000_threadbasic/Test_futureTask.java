package com.wyz.juc.c_000_threadbasic;

import java.util.concurrent.*;

/**
 * Test_futureTask
 *
 * @author wangyz
 * @date 2021/8/6 16:08
 */
public class Test_futureTask {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> future = new FutureTask<>(() -> {
            // TODO Auto-generated method stub
            Thread.sleep(1000);
            System.out.println("---------aaaa------------");
            return "aaa";
        });
        executor.execute(future);
        try {
            String result = future.get(500, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时");
            e.printStackTrace();
        } finally {
            future.cancel(true);
            executor.shutdown();
        }
    }
}
