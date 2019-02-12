package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/13 04:20
 * @description: 通过实现Runnable的方式创建线程
 */
public class ThreadImplements implements Runnable {

    @Override
    public void run() {
        for(int i = 1; i <= 1000; i ++){
            System.out.printf("%s执行:%d%n", Thread.currentThread().getName(), i);
        }
    }

}
