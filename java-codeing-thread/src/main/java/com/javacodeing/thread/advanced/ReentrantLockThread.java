package com.javacodeing.thread.advanced;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JDK Lock实现可重入锁
 */
public class ReentrantLockThread implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
    }

    private void set() {
        try {
            lock.lock();
            System.out.println("set");
            get(); // 调用get方法使用的是外层set方法的锁,如果lock不具备可重入性,在调用get方法时会产生死锁
        } finally {
            lock.unlock();
        }
    }

    private void get() {
        try {
            lock.lock();
            System.out.println("get");
        } finally {
            lock.unlock();
        }
    }

}
