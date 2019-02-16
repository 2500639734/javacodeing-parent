package com.javacodeing.thread.advanced;

import org.junit.Test;

/**
 * JDK读写锁测试
 */
public class ReadWriteLockTest {

    @Test
    public void readWriteLock() throws InterruptedException {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        // 写线程
        Thread wirteThread = new Thread(() -> {
            for (int i = 1; i <= 10; i ++){
                readWriteLock.put(i, i);
            }
        });

        // 读线程
        Thread readThread = new Thread(() -> {
            for (int i = 1; i <= 10; i ++){
                readWriteLock.get(i);
            }
        });

        wirteThread.start();
        readThread.start();

        Thread.sleep(3000);

    }

}
