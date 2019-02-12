package com.javacodeing.thread.basic;

import org.junit.Test;

/**
 * @author: shenke
 * @date: 2019/1/14 22:42
 * @description: 死锁测试
 */
public class ThreadDeadLockTest {

    /**
     * 模拟死锁,线程卡死
     * 两个线程都互相依赖对方持有的锁才能执行,造成死锁
     * @throws InterruptedException
     */
    @Test
    public void deadLock() throws InterruptedException {
        ThreadDeadLock threadDeadLock = new ThreadDeadLock();
        Thread thread1 = new Thread(threadDeadLock, "线程A");
        Thread thread2 = new Thread(threadDeadLock, "线程B");
        thread1.start();
        Thread.sleep(10);
        threadDeadLock.setFlag(false);
        thread2.start();

        Thread.sleep(30000);
    }

}
