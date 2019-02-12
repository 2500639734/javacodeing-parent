package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/14 22:35
 * @description: 死锁模拟
 * 使用两个线程运行,当线程A和线程B并发执行的时候
 * 线程A拿到了对象锁,但需要获取this锁执行完毕才会释放
 * 线程B拿到了this锁,但需要获取对象锁执行完毕才会释放
 * 此时两个线程都互相等待对方执行完毕后获取锁,但对方执行又依赖自己所持有的锁,造成死锁
 */
public class ThreadDeadLock implements Runnable {

    /**
     * 数量
     */
    private int number = 100;

    /**
     * 对象锁
     */
    private Object lock = new Object();

    /**
     * 执行方法,用于模拟死锁
     */
    private boolean flag = true;

    /**
     * 设置执行方法
     * @param flag
     */
    public void setFlag(boolean flag){
        this.flag = flag;
    }

    /**
     * 门票
     */
    private int tickets = number;

    @Override
    public void run() {
        if(flag){
            while (tickets > 0){
                synchronized (lock){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 先获取对象锁,再获取this锁
                    sell(); // 模拟售票
                }
            }
        } else {
            while (tickets > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 先获取this锁,再获取对象锁
                sell(); // 模拟售票
            }
        }
    }

    /**
     * 售票
     */
    private synchronized void sell(){
        synchronized (lock){
            if(tickets > 0){
                System.out.printf("%s出售第%d张门票,剩余%d张门票%n", Thread.currentThread().getName(), 100 - tickets + 1, tickets - 1);
                tickets --;
            }
        }
    }

}
