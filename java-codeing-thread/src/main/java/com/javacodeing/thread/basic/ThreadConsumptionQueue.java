package com.javacodeing.thread.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: shenke
 * @date: 2019/1/21 21:47
 * @description: 消费者队列
 */
public class ThreadConsumptionQueue implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    private volatile boolean flag = true;

    public ThreadConsumptionQueue(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (flag){
                Integer data = blockingQueue.poll(3 , TimeUnit.SECONDS);
                if(data == null){
                    flag = false;
                } else {
                    System.out.printf("消费数据:%d%n", data);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.printf("停止消费");
        }
    }

}
