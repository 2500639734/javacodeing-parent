package com.javacodeing.designmode.factory.abstraction;

/**
 * 儿童安全座椅
 */
public class ChildSafetySeat implements Seat {

    @Override
    public void install() {
        System.out.println("安装儿童安全座椅");
    }

}
