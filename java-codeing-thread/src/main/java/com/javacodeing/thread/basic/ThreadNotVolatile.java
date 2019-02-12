package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/15 00:07
 * @description: 不加volatile示例
 */
public class ThreadNotVolatile implements Runnable {

    private boolean run = true;

    public boolean getRun(){
        return run;
    }

    public void setRun(boolean run){
        this.run = run;
    }

    @Override
    public void run() {
        System.out.printf("%s线程开始%n", Thread.currentThread().getName());
        while(run){

        }
        System.out.printf("%s线程结束%n", Thread.currentThread().getName());
    }

}
