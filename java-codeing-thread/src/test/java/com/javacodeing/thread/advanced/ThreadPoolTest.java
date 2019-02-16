package com.javacodeing.thread.advanced;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程池使用测试
 * 线程池的作用:
 *      线程池作用就是限制系统中执行线程的数量。
 *      根据系统的环境情况，可以自动或手动设置线程数量，达到运行的最佳效果；
 *      少了浪费了系统资源，多了造成系统拥挤效率不高。用线程池控制线程数量，其他线程排队等候。
 *      一个任务执行完毕，再从队列的中取最前面的任务开始执行。若队列中没有等待进程，线程池的这一资源处于等待。
 *      当一个新任务需要运行时，如果线程池中有等待的工作线程，就可以开始运行了；否则进入等待队列
 * 为什么要用线程池:
 *      减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
 *      可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内存，而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机)。
 * corePoolSize:核心线程数(实际使用的线程数)
 * maximumPoolSize:最大线程数(线程池最多能使用的线程数)
 * keepAliveTime:线程空闲超时时间
 *
 * 线程池原理:
 * 1. 用户提交线程到线程池
 * 都是由ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue)
 * 构造函数封装
 * 2. 创建线程执行任务
 *  2.1 如果当前线程池中的线程数小于corePoolSize,则每来一个任务,就会创建一个线程执行任务
 *  2.2 如果当前线程池中的线程数大于corePoolSize,则每来一个任务,就会缓存到阻塞队列中
 *      2.2.1 如果队列已满
 *          2.2.1.1 判断当前线程数如果小于maximumPoolSize,重新创建线程执行
 *          2.2.1.2 判断当前线程数如果大于maximumPoolSize,拒绝任务执行
 *      2.2.2 如果队列未满,放入队列中等待之前的线程执行完毕后,复用创建线程
 *
 * CPU密集: 任务需要大量运算,而没有阻塞的情况,CPU全速运行
 * IO密集: 任务需要大量IO操作,产生阻塞
 * 合理配置线程池:
 *  CPU密集的情况下,建议配置线程数 = CPU核心数
 *  IO密集的情况下,建议配置线程数 = CPU核心数 * 2
 */
public class ThreadPoolTest {

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     * @throws InterruptedException
     */
    @Test
    public void cachedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i ++){
            Thread.sleep(1);
            executorService.execute(new ThreadPool());
        }

        Thread.sleep(3000);
    }

    /**
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     * @throws InterruptedException
     */
    @Test
    public void fixedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i ++){
            Thread.sleep(1);
            executorService.execute(new ThreadPool());
        }

        Thread.sleep(3000);
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行
     * @throws InterruptedException
     */
    @Test
    public void scheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i ++){
            Thread.sleep(1);
            scheduledExecutorService.schedule(new ThreadPool(), 3, TimeUnit.SECONDS);
        }

        Thread.sleep(7000);
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     * @throws InterruptedException
     */
    @Test
    public void singlaThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i ++){
            Thread.sleep(1);
            executorService.execute(new ThreadPool());
        }

        Thread.sleep(3000);
    }

    /**
     * 停止线程池
     * @throws InterruptedException
     */
    @Test
    public void shotdownThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i ++){
            executorService.execute(new ThreadPool());
        }

        // 停止线程调度,不会马上停止而是等待当前线程任务执行完毕
        executorService.shutdown();

        Thread.sleep(1000);
    }

    /**
     * 线程池原理,构造函数参数
     * @throws InterruptedException
     */
    @Test
    public void maxThreadPool() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(3));
        threadPoolExecutor.execute(new ThreadPool());
        threadPoolExecutor.execute(new ThreadPool());
        threadPoolExecutor.execute(new ThreadPool());
        threadPoolExecutor.execute(new ThreadPool());
        threadPoolExecutor.execute(new ThreadPool());

        // 到线程6执行时,超出了maximumPoolSize + 队列长度(3),拒绝执行任务并抛出java.util.concurrent.RejectedExecutionException异常
        // threadPoolExecutor.execute(new ThreadPoolRun());

        Thread.sleep(3000);
    }

    /**
     * Async Fature模式
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void asyncThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 异步提交任务到线程池,提交后子线程开始运行
        Future<String> future = executorService.submit(() -> {
            System.out.println("子线程开始执行... 需要3秒时间");
            Thread.sleep(3000);
            System.out.println("子线程执行完毕...");
            return "ok";
        });
        // 主线程不会阻塞
        System.out.println("主线程执行中...");
        // 获取子返回结果,阻塞等待子线程结果,之后的主线程也会阻塞
        String result = future.get();
        System.out.printf("子线程执行结果:%s\n", result);

        Thread.sleep(5000);
    }

}
