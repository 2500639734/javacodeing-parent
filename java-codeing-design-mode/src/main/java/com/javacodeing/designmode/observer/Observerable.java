package com.javacodeing.designmode.observer;


/**
 * 抽象被观察者接口
 * 定义了添加,删除,通知观察者的方法
 */
public interface Observerable {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();

}
