package com.javacodeing.designmode.adapter;

/**
 * 模拟中国电源接口实现
 */
public class CnPowerSupplyImpl implements CnPowerSupply {

    @Override
    public void connect() {
        System.out.println("使用中国电源,220v");
    }

}
