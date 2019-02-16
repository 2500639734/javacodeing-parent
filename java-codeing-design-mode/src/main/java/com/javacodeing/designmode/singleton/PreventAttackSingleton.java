package com.javacodeing.designmode.singleton;

/**
 * 单例模式防止反射攻击,以懒汉式为例
 * 创建多个对象时抛出异常
 */
public class PreventAttackSingleton {

    private static boolean created = false;

    // 当尝试创建多个对象时,抛出异常,可以防止通过反射机制破坏单例模式
    private PreventAttackSingleton () {
        if (!created) { // created == false
            created = !created;
        } else {
            throw new RuntimeException("禁止创建多个对象");
        }
    }

    private static PreventAttackSingleton preventAttackSingleton;

    public static synchronized PreventAttackSingleton getInstance () {
        if (preventAttackSingleton == null) {
            preventAttackSingleton = new PreventAttackSingleton();
        }
        return preventAttackSingleton;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        PreventAttackSingleton preventAttackSingleton1 = getInstance();
        PreventAttackSingleton preventAttackSingleton2 = getInstance();
        System.out.println(preventAttackSingleton1 == preventAttackSingleton2);

        Class clazz = Class.forName("com.javacodeing.designmode.singleton.PreventAttackSingleton");
        PreventAttackSingleton preventAttackSingleton = (PreventAttackSingleton) clazz.newInstance();
        System.out.println(preventAttackSingleton);
    }

}
