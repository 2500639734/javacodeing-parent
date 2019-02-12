package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/14 23:02
 * @description: ThreadLocal解决线程安全问题: 让每一个线程使用自己的局部变量,互不影响
 */
public class ThreadSynchronousLocal implements Runnable {

    private ThreadLocal threadLocal;

    public ThreadSynchronousLocal(ThreadLocal threadLocal){
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i ++){
            System.out.printf("%s输出:%d%n", Thread.currentThread().getName(), threadLocal.getNumber());
        }
    }

}
