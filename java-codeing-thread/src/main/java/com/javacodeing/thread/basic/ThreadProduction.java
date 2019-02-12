package com.javacodeing.thread.basic;

/**
 * @author: shenke
 * @date: 2019/1/21 20:07
 * @description: 模拟生产者线程
 */
public class ThreadProduction implements Runnable {

    private Person person;

    public ThreadProduction(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (person){
                if(person.isOnlyRead()){
                    try {
                        person.wait(); // 阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(count % 2 == 0){
                    person.setName("小明");
                    person.setSex("男");
                } else {
                    person.setName("小红");
                    person.setSex("女");
                }
                count ++;

                person.setOnlyRead(true);
                person.notify(); // 唤醒消费者线程
            }
        }
    }

}
