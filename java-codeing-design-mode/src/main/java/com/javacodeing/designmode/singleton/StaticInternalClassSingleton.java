package com.javacodeing.designmode.singleton;

/**
 * 静态内部类单例模式
 * 优点: 结合饿汉式和懒汉式的优点
 * 缺点: 需要两个类去完成,最终使用还是会创建StaticSingleton,并且是永久区
 */
public class StaticInternalClassSingleton {

    private StaticInternalClassSingleton () {

    }

    // static class 延迟加载
    // 外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化staticInternalClassSingleton,故而不占内存
    // 只有当getInstance()方法第一次被调用时，才会去初始化staticInternalClassSingleton
    private static class StaticSingleton {

        // static final 保证线程安全
        private static final StaticInternalClassSingleton staticInternalClassSingleton = new StaticInternalClassSingleton();

    }

    public static StaticInternalClassSingleton getInstance() {
        return StaticSingleton.staticInternalClassSingleton;
    }

    public static void main(String[] args) {
        StaticInternalClassSingleton staticInternalClassSingleton1 = getInstance();
        StaticInternalClassSingleton staticInternalClassSingleton2 = getInstance();
        System.out.println(staticInternalClassSingleton1 == staticInternalClassSingleton2);
    }

}
