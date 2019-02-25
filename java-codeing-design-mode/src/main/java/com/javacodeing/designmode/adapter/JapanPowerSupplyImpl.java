package com.javacodeing.designmode.adapter;

/**
 * 模拟日本电源接口实现
 */
public class JapanPowerSupplyImpl implements JapanPowerSupply {

    @Override
    public void connect() {
        System.out.println("使用日本电源,110v");
    }

}
