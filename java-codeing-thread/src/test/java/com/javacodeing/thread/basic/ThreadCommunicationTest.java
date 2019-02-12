package com.javacodeing.thread.basic;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: shenke
 * @date: 2019/1/21 19:45
 * @description: 多线程通信测试
 */
public class ThreadCommunicationTest {

    /**
     * 模拟测试生产者消费者模型
     * 使用synchronous关键字同步
     * 在生产消费中轮询效率太低,并且无法保证消费顺序
     * 因为无法保证哪个线程获取到cpu调度的控制权
     */
    @Test
    public void productionAndConsumptionSynchronous() throws InterruptedException {
        Person person = new Person();
        ThreadSynchronousProduction threadSynchronousProduction = new ThreadSynchronousProduction(person);
        ThreadSynchronousConsumption threadSynchronousConsumption = new ThreadSynchronousConsumption(person);
        Thread thread1 = new Thread(threadSynchronousProduction);
        Thread thread2 = new Thread(threadSynchronousConsumption);
        thread1.start();
        thread2.start();

        Thread.sleep(3000);
    }

    /**
     * 使用wait & notify模拟生产者和消费者测试 保证生产者先生产,然后消费者消费
     * wait,notify只能在锁代码块中使用,并且对象持有的同是一把锁
     * 为什么在object中? 因为需要对象调用,具体是哪个对象由开发者决定
     * wait与join区别? wait需要被唤醒,join不需要,wati需要在锁代码块中执行,join也不需要,wait是等待,join是让步优先
     * wait与sleep区别? wait会释放锁,sleep不会,sleep是Thread方法,而wait是Object方法
     * @throws InterruptedException
     */
    @Test
    public void productionAndConsumption() throws InterruptedException {
        Person person = new Person();
        ThreadProduction threadProduction = new ThreadProduction(person);
        ThreadConsumption threadConsumption = new ThreadConsumption(person);
        Thread thread1 = new Thread(threadProduction);
        Thread thread2 = new Thread(threadConsumption);
        thread1.start();
        thread2.start();

        Thread.sleep(3000);
    }

    /**
     * 使用LinkedBlockingQueue阻塞有界队列模拟生产消费
     * 使用AtomicInteger原子类模拟数据
     *
     * 队列: 先进先出,类似排队买票
     * 阻塞队列: 入队超出或出队为空时阻塞等待
     * 非阻塞队列: 入队超出或出对为空时直接放弃,不会阻塞等待
     * 有界队列: 创建时指定最大总数,不能超出
     * 无界队列: 超出默认最大总数会进行动态扩容
     * 有界阻塞队列: 指定总数,且阻塞
     * 有界非阻塞队列: 指定总数,且不阻塞
     * 无界阻塞队列: 动态扩容总数,且阻塞
     * 无界非阻塞队列: 动态扩容总数,且不阻塞
     * @throws InterruptedException
     */
    @Test
    public void productionAndConsumptionQueue() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        ThreadProductionQueue threadProductionQueue = new ThreadProductionQueue(blockingQueue);
        ThreadConsumptionQueue threadConsumptionQueue = new ThreadConsumptionQueue(blockingQueue);
        Thread thread1 = new Thread(threadProductionQueue);
        Thread thread2 = new Thread(threadConsumptionQueue);
        thread1.start();
        thread2.start();

        Thread.sleep(10000);

        // 停止生产
        threadProductionQueue.stop();

        Thread.sleep(4000);
    }

}
