package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/13 05:55
 * @description: synchronized关键字修饰指定对象
 */
public class ThreadSynchronousObject implements Runnable {

    private Object lock = new Object();

    /**
     * 数量
     */
    private int number = 100;

    /**
     * 门票
     */
    private int tickets = number;

    @Override
    public void run() {
        while (tickets > 0){
            sell(); // 模拟售票
        }
    }

    /**
     * 售票
     */
    private void sell(){
        synchronized (lock){
            if(tickets > 0){
                System.out.printf("%s出售第%d张门票,剩余%d张门票%n", Thread.currentThread().getName(), 100 - tickets + 1, tickets - 1);
                tickets --;
            }
        }
    }
}
