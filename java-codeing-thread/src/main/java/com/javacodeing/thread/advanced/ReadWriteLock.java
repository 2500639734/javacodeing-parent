package com.javacodeing.thread.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁实现
 * 读写锁 : 读读共存,读写不共存,写写不共存
 * 解决多线程同时读写时的线程安全问题
 */
public class ReadWriteLock {

    private volatile Map<Integer, Integer> cache = new HashMap<>();

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    public void put(Integer key, Integer value){
        try {
            writeLock.lock();
            System.out.printf("开始写入key = %d, value = %d\n", key, value);
            cache.put(key, value);
            System.out.printf("结束写入key = %d, value = %d\n", key, value);
        } finally {
            writeLock.unlock();
        }

    }

    public Integer get(Integer key){
        Integer value = null;
        try {
            readLock.lock();
            System.out.printf("开始读取key = %d\n", key);
            value = cache.get(key);
            System.out.printf("结束读取key = %d, value = %d\n", key, value);
        } finally {
            readLock.unlock();
        }
        return value;
    }



}
