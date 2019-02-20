package com.javacodeing.designmode.proxy.staticProxy;

import com.javacodeing.designmode.proxy.order.OrderServiceImpl;

/**
 * 静态代理模式: 每一个类都需要一个代理类
 * 被代理类每增加一个方法,代理类同样需要增加一个与之对应的代理方法
 */
public class OrderServiceStaticProxyClient {

    public static void main(String[] args) {
        OrderServiceStaticProxy orderServiceProxy = new OrderServiceStaticProxy(new OrderServiceImpl());
        orderServiceProxy.add();
    }

}
