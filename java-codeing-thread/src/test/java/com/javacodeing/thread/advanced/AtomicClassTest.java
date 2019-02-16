package com.javacodeing.thread.advanced;

import org.junit.Test;

/**
 * 测试JDK原子类解决线程安全问题
 */
public class AtomicClassTest {

    @Test
    public void atomicInteger () throws InterruptedException {
        AtomicThread atomicThread = new AtomicThread();
        Thread t1 = new Thread(atomicThread);
        Thread t2 = new Thread(atomicThread);
        t1.start();
        t2.start();

        Thread.sleep(3000);
    }


}
