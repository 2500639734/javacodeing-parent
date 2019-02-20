package com.javacodeing.designmode.proxy.cglibDynamicProxy;

import com.javacodeing.designmode.proxy.order.OrderServiceImpl;

/**
 * cglib动态代理,利用asm开源包,修改目标代理对象类的字节码生成子类进行代理
 * 目标代理类不需要实现接口
 */
public class OrderServiceCglibDynamicProxyClient {

    public static void main(String[] args) {
        // 创建代理实现对象
        OrderServiceCglibDynamicProxy orderServiceCglibDynamicProxy = new OrderServiceCglibDynamicProxy();
        // 获取代理对象
        OrderServiceImpl orderServiceImplProxy = (OrderServiceImpl) orderServiceCglibDynamicProxy.getInstance(new OrderServiceImpl());
        // 调用代理对象的代理方法
        orderServiceImplProxy.add();
    }

}
