package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/21 19:40
 * @description: 模拟生产者线程
 */
public class ThreadSynchronousProduction implements Runnable {

    private Person person;

    public ThreadSynchronousProduction(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        int count = 1;
        while (true){
            synchronized (person){
                if(count % 2 == 0){
                    person.setName("小明");
                    person.setSex("男");
                } else {
                    person.setName("小红");
                    person.setSex("女");
                }
                count ++;
            }
        }
    }

}
