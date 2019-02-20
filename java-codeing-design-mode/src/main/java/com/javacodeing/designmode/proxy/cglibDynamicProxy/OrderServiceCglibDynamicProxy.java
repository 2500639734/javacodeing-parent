package com.javacodeing.designmode.proxy.cglibDynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理实现
 */
public class OrderServiceCglibDynamicProxy implements MethodInterceptor {

    private Object target; // 目标代理对象

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置目标代理对象为父类,通过生成这个类的子类重写方法进行代理
        enhancer.setSuperclass(target.getClass());
        // 设置回调当前类的intercept方法
        enhancer.setCallback(this);
        // 创建返回代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("提交事务");
        return result;
    }

}
