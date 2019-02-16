package com.javacodeing.designmode.factory.abstraction;

/**
 * 手动挡变速器
 */
public class ManualTransmission implements Transmission {

    @Override
    public void install() {
        System.out.println("安装手动挡变速器");
    }

}
