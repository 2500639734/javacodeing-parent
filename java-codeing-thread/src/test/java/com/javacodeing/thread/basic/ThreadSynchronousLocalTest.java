package com.javacodeing.thread.basic;

import org.junit.Test;

/**
 * @author: shenke
 * @date: 2019/1/14 23:08
 * @description: 测试ThreadLocal
 */
public class ThreadSynchronousLocalTest {

    /**
     * 使用ThreadLocal解决线程安全问题.
     * ThreadLocal为每个线程单独创建局部变量,不会引发线程安全问题
     */
    @Test
    public void threadLocal(){
        ThreadLocal threadLocal = new ThreadLocal();
        ThreadSynchronousLocal threadSynchronousLocal = new ThreadSynchronousLocal(threadLocal);
        new Thread(threadSynchronousLocal, "线程A").start();
        new Thread(threadSynchronousLocal, "线程B").start();
    }

}
