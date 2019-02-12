package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/21 20:12
 * @description: 模拟消费者线程
 */
public class ThreadConsumption implements Runnable {

    private Person person;

    public ThreadConsumption(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            synchronized (person){
                if(!person.isOnlyRead()){
                    try {
                        person.wait(); // 阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.printf("%s,%s%n", person.getName(), person.getSex());

                person.setOnlyRead(false);
                person.notify(); // 唤醒生产者线程
            }
        }
    }

}
