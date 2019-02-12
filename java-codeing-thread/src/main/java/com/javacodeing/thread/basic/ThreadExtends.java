package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/13 04:23
 * @description: 通过继承Thread的方式创建线程
 */
public class ThreadExtends extends Thread {

    @Override
    public void run() {
        for(int i = 1; i <= 1000; i ++){
            System.out.printf("%s执行:%d%n", Thread.currentThread().getName(), i);
        }
    }

}
