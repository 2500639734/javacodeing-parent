package com.javacodeing.thread.basic;

import com.javacodeing.thread.basic.*;
import org.junit.Test;

/**
 * @author: shenke
 * @date: 2019/1/13 05:30
 * @description: 线程同步测试
 * synchronous关键字 :
 *  内置锁 : 是java内置的修饰符
 *  重入锁 : 通过synchronous修饰的代码块可以重复加锁,解锁
 *  互斥锁 : 通过synchronous修饰的代码块,同时只有一个线程可以操作,其它线程只能等待
 *  牺牲部分性能
 *  修饰非静态方法时: 锁的是当前对象或者指定对象,如果锁的对象不一致,线程对象不一样,无法同步
 *  修饰静态方法时: 锁的是当前类的字节码,静态数据存放在方法区中,属于类并对所有线程可见
 *      即使线程对象不一样,也可以同步,如果操作了成员变量,所操作的成员变量也需要使用static修饰(内存中只有一份),否则线程无法共享,也无法同步
 */
public class ThreadSynchronousTest {

    /**
     * 模拟售票,线程不安全导致的数据混乱
     * @throws InterruptedException
     */
    @Test
    public void threadInsecurity() throws InterruptedException {
        // 多个线程同时对全局变量进行写操作时,可能会产生线程安全问题
        // 全局变量对线程是不可见的,一个线程修改了数据,其它线程并不知道这个数据已经被修改了
        // 使用局部变量(线程内私有),或者对可能发生线程安全问题的代码进行同步处理,可以避免线程安全问题
        Thread thread1 = new Thread(new ThreadInsecurity(), "线程A");
        Thread thread2 = new Thread(new ThreadInsecurity(), "线程B");
        thread1.start();
        thread2.start();

        Thread.sleep(3000);
    }


    /**
     * 使用synchronous修饰当前对象解决线程安全问题
     * 与修饰方法不同的是锁的是当前类的字节码
     * 修饰方法锁的是当前对象
     * @throws InterruptedException
     */
    @Test
    public void synchronousThis() throws InterruptedException {
        // 这种情况会发生线程安全问题,因为锁的不是同一个对象
        ThreadSynchronousThis threadSynchronousThis1 = new ThreadSynchronousThis();
        ThreadSynchronousThis threadSynchronousThis2 = new ThreadSynchronousThis();
        Thread thread1 = new Thread(threadSynchronousThis1, "线程A");
        Thread thread2 = new Thread(threadSynchronousThis2, "线程B");
        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        // 这种情况不会发生线程安全问题,因为锁的对象是同一个
        ThreadSynchronousThis threadSynchronousThis = new ThreadSynchronousThis();
        Thread thread3 = new Thread(threadSynchronousThis, "线程C");
        Thread thread4 = new Thread(threadSynchronousThis, "线程D");
        thread3.start();
        thread4.start();
        Thread.sleep(3000);

    }

    /**
     * 使用synchronous修饰指定对象解决线程安全问题
     * 与修饰方法不同的是锁的是当前类的字节码
     * 修饰方法锁的是指定对象
     * @throws InterruptedException
     */
    @Test
    public void synchronousObject() throws InterruptedException {
        // 这种情况会发生线程安全问题,因为锁的不是同一个对象
        ThreadSynchronousObject threadSynchronousObject1 = new ThreadSynchronousObject();
        ThreadSynchronousObject threadSynchronousObject2 = new ThreadSynchronousObject();
        Thread thread1 = new Thread(threadSynchronousObject1, "线程A");
        Thread thread2 = new Thread(threadSynchronousObject2, "线程B");
        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        // 这种情况不会发生线程安全问题,因为锁的对象是同一个
        ThreadSynchronousObject threadSynchronousObject = new ThreadSynchronousObject();
        Thread thread3 = new Thread(threadSynchronousObject, "线程C");
        Thread thread4 = new Thread(threadSynchronousObject, "线程D");
        thread3.start();
        thread4.start();
        Thread.sleep(3000);
    }

    /**
     * 使用synchronous修饰方法解决线程安全问题
     * @throws InterruptedException
     */
    @Test
    public void synchronousMethod() throws InterruptedException {
        // 这种情况会发生线程安全问题,因为锁的不是同一个对象
        ThreadSynchronousMethod threadSynchronousMethod1 = new ThreadSynchronousMethod();
        ThreadSynchronousMethod threadSynchronousMethod2 = new ThreadSynchronousMethod();
        Thread thread1 = new Thread(threadSynchronousMethod1, "线程A");
        Thread thread2 = new Thread(threadSynchronousMethod2, "线程B");
        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        // 这种情况不会发生线程安全问题,因为锁的对象是同一个
        ThreadSynchronousMethod threadSynchronousMethod = new ThreadSynchronousMethod();
        Thread thread3 = new Thread(threadSynchronousMethod, "线程C");
        Thread thread4 = new Thread(threadSynchronousMethod, "线程D");
        thread3.start();
        thread4.start();
        Thread.sleep(3000);

    }

    /**
     * 使用synchronous修饰当前类解决线程安全问题
     * 与修饰方法不同的是锁的是当前类的字节码
     * 修饰方法锁的是当前对象
     * @throws InterruptedException
     */
    @Test
    public void synchronousClass() throws InterruptedException {
        // 这种情况不会发生线程安全问题,因为锁的是当前class的字节码
        Thread thread1 = new Thread(new ThreadSynchronousClass(), "线程A");
        Thread thread2 = new Thread(new ThreadSynchronousClass(), "线程B");
        thread1.start();
        thread2.start();

        Thread.sleep(3000);
    }

    /**
     * 使用synchronous修饰静态对象解决线程安全问题
     * 所操作的全局变量要使用static修饰,否则在线程中无法共享
     * @throws InterruptedException
     */
    @Test
    public void synchronousSynchronousStaticObject() throws InterruptedException {
        // 这种情况不会发生线程安全问题,因为静态对象对所有线程可见
        ThreadSynchronousStaticObject threadSynchronousStaticObject1 = new ThreadSynchronousStaticObject();
        ThreadSynchronousStaticObject threadSynchronousStaticObject2 = new ThreadSynchronousStaticObject();
        Thread thread1 = new Thread(threadSynchronousStaticObject1, "线程A");
        Thread thread2 = new Thread(threadSynchronousStaticObject2, "线程B");
        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        // 这种情况不会发生线程安全问题,因为静态对象对所有线程可见
        ThreadSynchronousStaticObject threadSynchronousStaticObject = new ThreadSynchronousStaticObject();
        Thread thread3 = new Thread(threadSynchronousStaticObject, "线程C");
        Thread thread4 = new Thread(threadSynchronousStaticObject, "线程D");
        thread3.start();
        thread4.start();
        Thread.sleep(3000);
    }

    /**
     * 使用synchronous修饰静态方法解决线程安全问题
     * 所操作的全局变量要使用static修饰,否则在线程中无法共享
     * @throws InterruptedException
     */
    @Test
    public void synchronousSynchronousStaticMethod() throws InterruptedException {
        // 这种情况不会发生线程安全问题,因为静态方法对所有线程可见
        ThreadSynchronousStaticMethod threadSynchronousStaticMethod1 = new ThreadSynchronousStaticMethod();
        ThreadSynchronousStaticMethod threadSynchronousStaticMethod2 = new ThreadSynchronousStaticMethod();
        Thread thread1 = new Thread(threadSynchronousStaticMethod1, "线程A");
        Thread thread2 = new Thread(threadSynchronousStaticMethod2, "线程B");
        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        // 这种情况不会发生线程安全问题,因为静态方法对所有线程可见
        ThreadSynchronousStaticMethod threadSynchronousStaticMethod = new ThreadSynchronousStaticMethod();
        Thread thread3 = new Thread(threadSynchronousStaticMethod, "线程C");
        Thread thread4 = new Thread(threadSynchronousStaticMethod, "线程D");
        thread3.start();
        thread4.start();
        Thread.sleep(3000);
    }

}
