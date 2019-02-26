package com.javacodeing.designmode.observer;

public class ObserverClient {

    public static void main(String[] args) {
        WechatServer wechatServer = new WechatServer();

        Observer userZhang = new User("张三");
        Observer userLi = new User("李四");
        Observer userWang = new User("王五");
        wechatServer.registerObserver(userZhang);
        wechatServer.registerObserver(userLi);
        wechatServer.registerObserver(userWang);
        wechatServer.setInfomation("现在是10点25分");

    }

}
