package com.javacodeing.thread.advanced;

import com.lmax.disruptor.EventHandler;

/**
 * disruptor消费端
 */
public class DisruptorConsumer implements EventHandler<DataEvent> {

    @Override
    public void onEvent(DataEvent dataEvent, long l, boolean b) throws Exception {
        System.out.printf("消费到消息,value = %d\n", dataEvent.getValue());
    }

}
