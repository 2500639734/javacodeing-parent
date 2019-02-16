package com.javacodeing.designmode.factory.abstraction;

/**
 * 自动加热座椅
 */
public class AutomaticHeatingSeat implements Seat {

    @Override
    public void install() {
        System.out.println("安装自动加热座椅");
    }

}
