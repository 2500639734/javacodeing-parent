package com.javacodeing.thread.basic;

import java.util.concurrent.Callable;

/**
 * @author: shenke
 * @date: 2019/1/21 22:30
 * @description: callable创建有返回值的线程
 */
public class TaskCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.printf("开始执行任务%n");
        Thread.sleep(5000);
        System.out.printf("执行任务结束%n");
        return "success";
    }

}
