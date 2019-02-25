package com.javacodeing.designmode.adapter;

/**
 * 适配器模式:类适配器,对象适配,接口适配
 * 作用:兼容接口
 */
public class AdapterClient {

    public static void main(String[] args) {
        // 220v电源接口
        CnPowerSupply cnPowerSupply = new CnPowerSupplyImpl();
        // 220v电源接口适配器适配110v电源
        PowerSupplyAdapter powerSupplyAdapter = new PowerSupplyAdapter(cnPowerSupply);
        // 使用110v电源的电饭煲
        JapanRiceCooker japanRiceCooker = new JapanRiceCooker(powerSupplyAdapter);
        japanRiceCooker.cook();
    }

}
