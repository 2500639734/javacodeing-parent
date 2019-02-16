package com.javacodeing.thread.advanced;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类操作解决多线程共享全局变量引发的线程安全问题
 * 原子类: 内部使用cas无锁机制,非阻塞,效率高
 */
public class AtomicThread implements Runnable {

    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            int count = setCount();
            if (count > 100) {
                break;
            }
            System.out.printf("count = %d\n", count);
        }
    }

    public int setCount (){
        return count.incrementAndGet();
    }

}
