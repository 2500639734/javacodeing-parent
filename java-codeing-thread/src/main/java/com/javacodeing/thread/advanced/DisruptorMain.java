package com.javacodeing.thread.advanced;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorMain {

    public static void main(String[] args) {
        // 创建可缓存的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建Event工厂
        DataEventFactory dataEventFactory = new DataEventFactory();
        // 设置ringbuffer大小,2的n次方,因为内部是使用的取模算法
        int ringbufferSize = 1024 * 2;
        // 创建disruptor
        Disruptor<DataEvent> disruptor = new Disruptor<DataEvent>(dataEventFactory, ringbufferSize, executorService, ProducerType.MULTI, new YieldingWaitStrategy());
        // 注册消费端,默认多个消费者是重复消费,可调整设置为多个消费者
        disruptor.handleEventsWith(new DisruptorConsumer());

        // 启动disruptor
        disruptor.start();

        // 创建ringbuffer容器
        RingBuffer<DataEvent> ringbuffer = disruptor.getRingBuffer();
        // 创建生产者
        DisruptorProducer disruptorProducer = new DisruptorProducer(ringbuffer);
        // 设置缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        // 生产数据
        for (int i = 1; i <= 100; i ++) {
            byteBuffer.putLong(0, i);
            disruptorProducer.onData(byteBuffer);
        }

        // 关闭连接池
        executorService.shutdown();
        // 关闭disruptor
        disruptor.shutdown();
    }

}
