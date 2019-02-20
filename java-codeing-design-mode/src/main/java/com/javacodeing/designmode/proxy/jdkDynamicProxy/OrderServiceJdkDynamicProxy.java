package com.javacodeing.designmode.proxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理实现
 */
public class OrderServiceJdkDynamicProxy implements InvocationHandler {

    private Object target; // 目标代理对象

    public OrderServiceJdkDynamicProxy (Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        Object result = method.invoke(target, args);
        System.out.println("提交事务");
        return result;
    }


}
