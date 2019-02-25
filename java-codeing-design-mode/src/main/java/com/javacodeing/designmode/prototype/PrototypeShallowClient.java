package com.javacodeing.designmode.prototype;

/**
 * 原型模式,构建对象,浅拷贝
 * 浅拷贝,只拷贝基本类型,共用引用类型,String除外会重新开辟内存空间,因为是final的
 */
public class PrototypeShallowClient {

    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book();
        book1.setTitle("图书1");

        Book book2 = book1.clone();
        book2.setTitle("图书2");
        book2.add("图片2");

        System.out.println("book1 == book2:" + (book1 == book2));
        System.out.println("book1:" + book1.toString());
        System.out.println("book2:" +book2.toString());
        System.out.println("book1:" + book1.toString());

    }

}
