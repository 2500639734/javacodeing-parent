package com.javacodeing.thread.advanced;

import org.junit.Test;

/**
 * 测试可重入锁
 * 可重入锁:锁可以通过方法递归传递,将外层方法的同一把锁传递到内层调用的方法中
 * synchronirzed : 重量级
 * lock : 轻量级
 */
public class ReentrantLockTest {

    /**
     * 测试synchronirzed关键字实现的可重入锁
     */
    @Test
    public void reentrantSynchronirzed() throws InterruptedException {
        new Thread(new ReentrantSynchronirzedThread()).start();

        Thread.sleep(3000);
    }

    /**
     * 测试JDK Lock实现的可重入锁
     * @throws InterruptedException
     */
    @Test
    public void reentrantLock() throws InterruptedException {
        new Thread(new ReentrantLockThread()).start();

        Thread.sleep(3000);
    }

}
