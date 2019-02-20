package com.javacodeing.designmode.proxy.order;

/**
 * 模拟订单实现
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public void add() {
        System.out.println("下单");
    }

}
