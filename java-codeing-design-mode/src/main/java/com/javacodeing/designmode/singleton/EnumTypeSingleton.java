package com.javacodeing.designmode.singleton;

/**
 * 枚举方式单例模式实现
 * 优点: jvm保证了单例和线程安全,防止反射和反序列化漏洞
 * 缺点: 不能达到延迟加载的目的
 */
public class EnumTypeSingleton {

    private EnumTypeSingleton () {

    }

    private static enum EnumSingleton {

        INSTANCE;

        private EnumTypeSingleton enumTypeSingleton;

        private EnumSingleton () {
            enumTypeSingleton = new EnumTypeSingleton();
        }

        private EnumTypeSingleton getInstance () {
            return this.enumTypeSingleton;
        }

    }

    public static EnumTypeSingleton getInstance () {
        return EnumSingleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        EnumTypeSingleton enumTypeSingleton1 = getInstance();
        EnumTypeSingleton enumTypeSingleton2 = getInstance();
        System.out.println(enumTypeSingleton1 == enumTypeSingleton2);
    }

}
