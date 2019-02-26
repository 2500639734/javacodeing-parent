package com.javacodeing.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义被观察者
 */
public class WechatServer implements Observerable {

    private List<Observer> list = new ArrayList<>();

    private String message;

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.callback(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        // 消息更新，通知所有观察者
        notifyObserver();
    }

}
