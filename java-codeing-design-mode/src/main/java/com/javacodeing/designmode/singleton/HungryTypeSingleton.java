package com.javacodeing.designmode.singleton;

/**
 * 饿汉式单例模式
 * 优点:类初始化的时候就会创建对象,线程安全,调用效率比较高
 * 缺点:如果不使用该对象的情况下,会造成内存资源的浪费
 */
public class HungryTypeSingleton {

    /**
     * static 常量存放在JVM永久区(方法区),垃圾回收器不会对其进行回收
     * static final修饰,不能被改变,不会产生线程安全问题
     */
    private static final HungryTypeSingleton hungryTypeSingleton = new HungryTypeSingleton();

    private HungryTypeSingleton () {

    }

    public static HungryTypeSingleton getInstance () {
        return hungryTypeSingleton;
    }

    public static void main(String[] args) {
        HungryTypeSingleton hungryTypeSingleton1 = getInstance();
        HungryTypeSingleton hungryTypeSingleton2 = getInstance();
        System.out.println(hungryTypeSingleton1 == hungryTypeSingleton2);
    }

}
