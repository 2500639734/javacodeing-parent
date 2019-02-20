package com.javacodeing.designmode.proxy.staticProxy;

import com.javacodeing.designmode.proxy.order.OrderService;
import com.javacodeing.designmode.proxy.order.OrderServiceImpl;

public class OrderServiceStaticProxy implements OrderService {

    private OrderServiceImpl orderServiceImpl;

    public OrderServiceStaticProxy(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public void add() {
        System.out.println("开启事务");
        orderServiceImpl.add();
        System.out.println("提交事务");
    }
}
