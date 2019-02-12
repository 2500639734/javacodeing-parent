package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/13 06:09
 * @description: synchronized关键字使用静态锁
 */
public class ThreadSynchronousStaticObject implements Runnable {

    /**
     * 静态对象锁,所使用的局部变量也必须是静态的,线程可以共享
     */
    private static Object lock = new Object();

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
    private void sell(){
        synchronized (lock){
            if(tickets > 0){
                System.out.printf("%s出售第%d张门票,剩余%d张门票%n", Thread.currentThread().getName(), 100 - tickets + 1, tickets - 1);
                tickets --;
            }
        }
    }

}
