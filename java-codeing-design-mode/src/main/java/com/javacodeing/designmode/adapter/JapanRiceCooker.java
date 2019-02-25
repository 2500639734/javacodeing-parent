package com.javacodeing.designmode.adapter;

/**
 * 模拟日本进口电饭煲,只能使用110v电源
 */
public class JapanRiceCooker {

    private JapanPowerSupply japanPowerSupply;

    public JapanRiceCooker(JapanPowerSupply japanPowerSupply) {
        this.japanPowerSupply = japanPowerSupply;
    }

    public void cook(){
        japanPowerSupply.connect();
        System.out.println("开始做饭");
    }

}
