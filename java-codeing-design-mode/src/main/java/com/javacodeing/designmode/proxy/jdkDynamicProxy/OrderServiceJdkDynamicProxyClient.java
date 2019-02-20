package com.javacodeing.designmode.proxy.jdkDynamicProxy;

import com.javacodeing.designmode.proxy.order.OrderService;
import com.javacodeing.designmode.proxy.order.OrderServiceImpl;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理,jdk自带,被代理类必须实现接口
 * 根据类加载器和接口生成目标类的代理对象,使用实现目标对象接口的方式进行代理
 * 只能对实现接口的类进行代理
 * 与静态代理的区别:假设代理方法前后逻辑一致,那么新增需要被代理的类时不用新增对应的代理类
 */
public class OrderServiceJdkDynamicProxyClient {

    public static void main(String[] args) {
        // 创建目标代理对象
        OrderService orderService = new OrderServiceImpl();
        // 传递目标代理对象,invoke实现了调用目标方法时的前后增强
        OrderServiceJdkDynamicProxy orderServiceJdkDynamicProxy = new OrderServiceJdkDynamicProxy(orderService);
        // 获取目标代理对象的类加载器
        ClassLoader classLoader = orderService.getClass().getClassLoader();
        // 获取目标代理对象实现的接口
        Class<?>[] interfaces = orderService.getClass().getInterfaces();
        // 生成目标代理对象的代理对象
        OrderService orderServiceProxy = (OrderService) Proxy.newProxyInstance(classLoader, interfaces, orderServiceJdkDynamicProxy);
        // 调用代理对象的方法
        orderServiceProxy.add();
    }

}
