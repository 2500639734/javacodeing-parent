package com.javacodeing.designmode.singleton;

/**
 * 懒汉式单例模式
 * 优点: 初始化的时候不会创建对象,等到真正需要使用的时候再去创建,能够节约内存,达到延迟加载的目的
 * 缺点: 线程不安全,需要自己解决线程安全问题
 */
public class LazyTypeSingleton {

    // 不能像饿汉式一样使用static final修饰,因为这样必须有初始值,且无法改变,不能达到延迟加载的效果
    private static LazyTypeSingleton lazyTypeSingleton;

    private LazyTypeSingleton () {

    }

    public static synchronized LazyTypeSingleton getInstance () {
        if (lazyTypeSingleton == null) {
            lazyTypeSingleton = new LazyTypeSingleton();
        }
        return lazyTypeSingleton;
    }

    public static void main(String[] args) {
        LazyTypeSingleton lazyTypeSingleton1 = getInstance();
        LazyTypeSingleton lazyTypeSingleton2 = getInstance();
        System.out.println(lazyTypeSingleton1 == lazyTypeSingleton2);
    }

}
