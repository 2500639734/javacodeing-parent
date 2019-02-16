package com.javacodeing.thread.advanced;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 通过disruptor进行数据交换的数据结构
 * disruptor: 高性能java并发编程框架,环形数组 + cas无锁机制
 */
@Getter
@Setter
@ToString
public class DataEvent {

    private Long value;

}
