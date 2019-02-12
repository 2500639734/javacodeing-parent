package com.javacodeing.thread.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: shenke
 * @date: 2019/1/21 21:41
 * @description: 生产者队列
 */
public class ThreadProductionQueue implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    private volatile boolean flag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    public ThreadProductionQueue(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (flag){
                Thread.sleep(1000);
                Integer data = atomicInteger.incrementAndGet();
                boolean isOffer = blockingQueue.offer(data, 3, TimeUnit.SECONDS);
                if(isOffer){
                    System.out.printf("生产数据:%d%n", data);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.printf("停止生产%n");
        }
    }

    public void stop(){
        this.flag = false;
    }

}
