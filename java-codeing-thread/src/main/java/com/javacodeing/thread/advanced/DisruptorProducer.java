package com.javacodeing.thread.advanced;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * disruptor生产者
 */
public class DisruptorProducer {

    private RingBuffer<DataEvent> ringBuffer;

    public DisruptorProducer (RingBuffer ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData (ByteBuffer byteBuffer) {
        // 获取事件队列的下标位置
        long sequence = ringBuffer.next();
        try {
            // 取出空的event队列
            DataEvent dataEvent = ringBuffer.get(sequence);
            // 给空的event队列设置值
            dataEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 发送数据,放在finally中避免阻塞
            ringBuffer.publish(sequence);
            System.out.println("生产者发送数据");
        }
    }

}
