package com.javacodeing.thread.advanced;

import com.lmax.disruptor.EventFactory;

/**
 * DataEvent工厂
 */
public class DataEventFactory implements EventFactory<DataEvent> {

    @Override
    public DataEvent newInstance() {
        return new DataEvent();
    }

}
