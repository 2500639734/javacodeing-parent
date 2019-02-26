package com.javacodeing.designmode.observer;

/**
 * 抽象观察者接口
 * 当被观察者调用notifyObserver方法时,callback方法会被回调
 */
public interface Observer {

    void callback(String message);

}
