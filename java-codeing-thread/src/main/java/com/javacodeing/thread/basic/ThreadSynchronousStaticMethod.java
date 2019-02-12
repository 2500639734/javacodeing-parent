package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/13 06:07
 * @description: synchronized关键字修饰静态方法
 */
public class ThreadSynchronousStaticMethod implements Runnable {

    /**
     * 数量
     */
    private static int number = 100;

    /**
     * 门票
     */
    private static int tickets = number;

    @Override
    public void run() {
        while (tickets > 0){
            sell(); // 模拟售票
        }
    }

    /**
     * 售票
     */
    private synchronized static void sell(){
        if(tickets > 0){
            System.out.printf("%s出售第%d张门票,剩余%d张门票%n", Thread.currentThread().getName(), 100 - tickets + 1, tickets - 1);
            tickets --;
        }
    }

}
