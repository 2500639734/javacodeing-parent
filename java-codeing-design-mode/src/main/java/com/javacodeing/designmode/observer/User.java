package com.javacodeing.designmode.observer;

public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void callback(String message) {
        System.out.printf("%s收到推送消息:%s\n", name, message);
    }

}
