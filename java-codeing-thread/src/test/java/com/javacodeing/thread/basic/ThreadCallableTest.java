package com.javacodeing.thread.basic;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: shenke
 * @date: 2019/1/21 22:32
 * @description: callable future模式测试
 */
public class ThreadCallableTest {

    /**
     * callable 创建有返回结果的线程
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void taskCallable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(); // 线程池
        TaskCallable taskCallable = new TaskCallable();
        Future<String> future = executorService.submit(taskCallable);
        System.out.printf("主线程运行1%n"); // get之前将不会阻塞
        String result = future.get(); // 获取返回结果,这一步是wait阻塞的
        System.out.printf("主线程运行2%n"); // 调用get之后会阻塞,需要等待返回结果
        System.out.printf("执行任务返回结果:%s%n", result);

        Thread.sleep(3000);
    }

    @Test
    public void taskCallableNewThread() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(); // 线程池
        TaskCallable taskCallable = new TaskCallable();
        Future<String> future = executorService.submit(taskCallable);

        new Thread(() -> {
            String result = null; // 获取返回结果,这一步是wait阻塞的
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("执行任务返回结果:%s%n", result);
        }).start();

        System.out.printf("主线程运行%n"); // 创建线程用于接收返回结果,这一步就不会阻塞

        Thread.sleep(7000);
    }

}
