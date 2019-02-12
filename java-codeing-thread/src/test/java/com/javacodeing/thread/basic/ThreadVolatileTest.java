package com.javacodeing.thread.basic;

import org.junit.Test;

/**
 * @author: shenke
 * @date: 2019/1/15 00:09
 * @description: volatile关键字用法
 * 每个全局变量,都存放在主内存中(jmm内存模型的概念,与jvm内存结构有区别)
 * 每个线程的本地内存存放一份主内存的副本
 * 并发场景下,A,B线程操作了变量,由于一个线程操作变量之后在另一个变量操作之前没有及时刷新到主内存中,引发线程安全问题
 * volatile可以保证全局共享变量在线程中的可见性,也就是一个线程修改了volatile修饰的全局共享变量之后,会马上刷新到主内存中
 * 其它线程可以及时知道变量已经被修改,从主内存中同步最新的数据到自己的本地内存中
 *
 * volatile与synchronous的区别
 * volatile只保证线程的可见性,不保证原子性,无法完全解决线程安全问题,禁用重排序
 * synchronous不仅保证可见性(因为同一时刻只有一个线程在操作数据),也保证原子性,不会禁用重排序
 * volatile比synchronous执行效率要高,因为volatile修饰的变量数据还是可以多线程同时操作的
 * 重排序: cpu会对代码执行优化,但不会对有依赖关系的代码做重排序(为了保证代码执行结果不会因此发生改变)
 * 数据依赖关系:
 *  int a = 3; int b = 4; int c = a + b; 变量c的执行依赖a,b变量的初始化
 *  但a,b初始化互相不依赖其它代码,所以在多线程环境下可能发生重排序,即先初始化b,再初始化a
 *  但不会对c变量这行进行重排序,因为它依赖ab变量的初始化,可能导致不一样的结果
 */
public class ThreadVolatileTest {

    /**
     * run变量不加volatile的情况
     * @throws InterruptedException
     */
    @Test
    public void notVolatile() throws InterruptedException {
        ThreadNotVolatile threadNotVolatile = new ThreadNotVolatile();
        Thread thread = new Thread(threadNotVolatile, "测试");
        thread.start();
        Thread.sleep(3000);
        // 主线程将run修改为false
        threadNotVolatile.setRun(false);

        System.out.printf("flag:%s%n", threadNotVolatile.getRun());

        // 虽然已经修改为flase,并且刷新到主内存也是false,但是由于测试线程的本地内存还是true,没有同步主内存数据
        // 所以测试线程将不会结束
        Thread.sleep(10000);

    }

    /**
     * run方法使用volatile关键字修饰的情况
     * @throws InterruptedException
     */
    @Test
    public void isVolatile() throws InterruptedException {
        ThreadVolatile threadVolatile = new ThreadVolatile();
        Thread thread = new Thread(threadVolatile, "测试");
        thread.start();
        Thread.sleep(3000);
        // 主线程将run修改为false
        threadVolatile.setRun(false);

        System.out.printf("flag:%s%n", threadVolatile.getRun());

        // flase,并且刷新到主内存也是false,测试线程及时更新了自己的本地内存
        // 所以一旦修改为false之后测试线程马上就结束了
        Thread.sleep(10000);

    }

}
