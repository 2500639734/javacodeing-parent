package com.javacodeing.thread.basic;

import com.javacodeing.thread.basic.ThreadExtends;
import com.javacodeing.thread.basic.ThreadImplements;
import org.junit.Test;

/**
 * @author: shenke
 * @date: 2019/1/13 04:25
 * @description: 线程创建测试
 */
public class ThreadCreateTest {

    /**
     * 测试继承方式创建线程
     */
    @Test
    public void testThreadExtends(){
        new Thread(new ThreadExtends()).start();
    }

    /**
     * 测试实现接口方式创建线程
     */
    @Test
    public void testThreadImplements(){
        new Thread(new ThreadImplements()).start();
    }

    /**
     * 测试匿名内部类方式创建线程
     */
    @Test
    public void testThreadAnonymous(){
        new Thread(() -> {
            for(int i = 1; i <= 10; i ++){
                System.out.printf("%s执行:%d%n", Thread.currentThread().getName(), i);
            }
        }).start();
    }

}
