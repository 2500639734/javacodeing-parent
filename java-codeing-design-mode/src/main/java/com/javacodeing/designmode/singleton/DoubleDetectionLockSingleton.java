package com.javacodeing.designmode.singleton;

/**
 * 双重检测锁单例模式
 * 优点: 由懒汉式改进而来,是对懒汉式synchronized的优化
 * 缺点: 重排序会引发线程安全问题,可能会创建多个对象,volatile不能保证原子性
 */
public class DoubleDetectionLockSingleton {

    private DoubleDetectionLockSingleton () {

    }

    // 禁止重排序
    private static volatile DoubleDetectionLockSingleton doubleDetectionLockSingleton;

    public static DoubleDetectionLockSingleton getInstance () {
        if (doubleDetectionLockSingleton == null) {
            synchronized (DoubleDetectionLockSingleton.class) {
                if (doubleDetectionLockSingleton == null) {
                    doubleDetectionLockSingleton = new DoubleDetectionLockSingleton();
                }
             }
        }
        return doubleDetectionLockSingleton;
    }

    public static void main(String[] args) {
        DoubleDetectionLockSingleton doubleDetectionLockSingleton1 = getInstance();
        DoubleDetectionLockSingleton doubleDetectionLockSingleton2 = getInstance();
        System.out.println(doubleDetectionLockSingleton1 == doubleDetectionLockSingleton2);
    }

}
