package com.javacodeing.thread.advanced;

/**
 * 用于测试线程池的线程
 */
public class ThreadPool implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s正在执行\n", Thread.currentThread().getName());
    }

}
