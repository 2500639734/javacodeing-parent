package com.javacodeing.designmode.prototype;

/**
 * 原型模式,构建对象,深拷贝
 * 在内存中开辟新的空间,拷贝基本类型和引用类型,与被拷贝对象没有共用属性和依赖
 */
public class PrototypeDeepClient {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        person1.setAge(10);

        Person person2 = person1.clone();
        person2.setAge(20);
        person2.add("李四");

        System.out.println("person1 == person2:" + (person1 == person2));
        System.out.println("person1:" + person1.toString());
        System.out.println("person2:" +person2.toString());
        System.out.println("person1:" + person1.toString());

    }

}
