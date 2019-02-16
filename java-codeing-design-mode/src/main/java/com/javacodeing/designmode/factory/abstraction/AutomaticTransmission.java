package com.javacodeing.designmode.factory.abstraction;

/**
 * 自动挡变速器
 */
public class AutomaticTransmission implements Transmission {

    @Override
    public void install() {
        System.out.println("安装自动挡变速器");
    }

}
