package com.javacodeing.thread.basic;

import com.javacodeing.thread.basic.ThreadExtends;
import org.junit.Test;

/**
 * @author: shenke
 * @date: 2019/1/13 04:30
 * @description: 线程常用方法测试
 */
public class ThreadMethodsTest {

    /**
     * 指定线程名称
     */
    @Test
    public void setName(){
        // setName指定
        ThreadExtends threadExtends = new ThreadExtends();
        Thread thread = new Thread(threadExtends);
        thread.setName("线程A");
        thread.start();

        // 创建同时指定
        new Thread(new ThreadExtends(),"线程B").start();
    }

    /**
     * 启动线程,start和run方法的区别
     */
    @Test
    public void start() throws InterruptedException {
        // run方法,线程是同步运行的,并且当前执行的线程是main主线程
        // 使用run方法的话,因为是main线程运行,setName无效,并且由于是同步的,多线程失去意义,所以启动线程是使用start方法
        new Thread(new ThreadExtends()).run();
        new Thread(new ThreadExtends()).run();

        // start方法,线程是异步执行的,线程A和线程B同时交替执行
        new Thread(new ThreadExtends(),"线程A").start();
        new Thread(new ThreadExtends(),"线程B").start();

        Thread.sleep(3000);

    }

    /**
     * 线程优先级
     * @throws InterruptedException
     */
    @Test
    public void level() throws InterruptedException {
        // 设置线程优先级(1-10,1最小,10最大),默认为5
        // 线程A获取到cpu资源调度的机会将大于线程B
        Thread thread1 = new Thread(new ThreadExtends(), "线程A");
        Thread thread2 = new Thread(new ThreadExtends(), "线程B");
        thread1.setPriority(10);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();

        Thread.sleep(3000);
    }

    /**
     * 测试守护线程,junit无法模拟,因此这个方法中只描述理论
     */
    @Test
    public void testDaemon() {
        // setDaemon(true)设置一个线程为守护线程
        // 当主线程(main)运行结束,守护线程会一起结束
        // 如果是自己创建的线程,当主线程结束后不会影响普通线程的运行,也就是说还没有执行完的普通线程如果没异常的话会继续执行
        Thread thread1 = new Thread(new ThreadExtends(), "线程A");
        thread1.setDaemon(true);
    }

    /**
     * 线程的生命周期,junit无法模拟,因此这个方法中只描述理论
     */
    @Test
    public void lifeCycle(){
        // 1.新建状态 : 创建线程但还未调用start()方法,进入新建状态
        // 2.就绪状态 : 调用start()方法之后,这时线程会等待cpu资源调度,进入就绪状态
        // 3.运行状态 : 调用start()方法并且抢占到cpu执行权后,开始执行,进入运行状态
        // 4.阻塞状态 : 当线程失去cpu执行权,或者cpu执行权被其它线程抢占,或者调用sleep、wait等方法时,进入阻塞状态,等待cpu下一次的调度
        // 5.死亡状态 : 当线程(run()方法)执行完毕,或者在执行过程中出现了未捕获的异常,直接销毁进入死亡状态

        // 当线程从阻塞状态恢复后,重新进入就绪状态,等待调度后执行,而不是直接进入执行状态
    }

    /**
     * join方法
     * @throws InterruptedException
     */
    @Test
    public void join() throws InterruptedException {
        // join方法让当前线程等待其它线程执行完毕后再执行,再执行并不是立即执行,而是需要抢占到cpu执行权
        // C线程必须等待B线程执行完毕后再执行,B线程必须等待A线程执行完毕后再执行,所以这里执行顺序是 A > B > C
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i <= 1000; i ++){
                System.out.printf("%s执行:%d%n", Thread.currentThread().getName(), i);
            }
        }, "线程A");
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 1; i <= 1000; i ++){
                System.out.printf("%s执行:%d%n", Thread.currentThread().getName(), i);
            }
        }, "线程B");
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 1; i <= 1000; i ++){
                System.out.printf("%s执行:%d%n", Thread.currentThread().getName(), i);
            }
        }, "线程C");
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(3000);
    }

}
