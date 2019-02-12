package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/14 23:11
 * @description: 本地共享变量
 */
public class ThreadLocal {

    private java.lang.ThreadLocal<Integer> threadLocal = new java.lang.ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 0;
        };
    };

    public Integer getNumber(){
        Integer count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }

}
