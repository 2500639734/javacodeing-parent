package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/15 00:24
 * @description: volatile关键字示例
 */
public class ThreadVolatile implements Runnable {

    /**
     * volatile关键字保证线程间的数据可见性,一个线程对其修改后别的线程能及时将数据更新到自己的本地内存中
     */
    private volatile boolean run = true;

    public boolean getRun(){
        return run;
    }

    public void setRun(boolean run){
        this.run = run;
    }

    @Override
    public void run() {
        System.out.printf("%s线程开始%n", Thread.currentThread().getName());
        while (run){

        }
        System.out.printf("%s线程结束%n", Thread.currentThread().getName());
    }

}
