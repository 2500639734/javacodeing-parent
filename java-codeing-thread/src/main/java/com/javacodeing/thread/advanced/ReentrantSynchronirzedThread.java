package com.javacodeing.thread.advanced;

/**
 * synchronized关键字实现可重用锁
 */
public class ReentrantSynchronirzedThread implements Runnable {

    @Override
    public void run() {
        set();
    }

    private synchronized void set() {
        System.out.println("set");
        get(); // 调用get方法使用的是外层set方法的锁,如果synchronized不具备可重入性,在调用get方法时会产生死锁
    }

    private synchronized void get() {
        System.out.println("get");
    }

}
