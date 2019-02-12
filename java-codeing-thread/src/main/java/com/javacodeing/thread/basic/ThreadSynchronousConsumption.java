package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/21 19:43
 * @description: 模拟消费者线程
 */
public class ThreadSynchronousConsumption implements Runnable {

    private Person person;

    public ThreadSynchronousConsumption(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            synchronized (person){
                System.out.printf("%s,%s%n", person.getName(), person.getSex());
            }
        }
    }

}
