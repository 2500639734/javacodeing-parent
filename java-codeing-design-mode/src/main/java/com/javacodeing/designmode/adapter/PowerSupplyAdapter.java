package com.javacodeing.designmode.adapter;

/**
 * 模拟电源适配器,将220v电源转为110v电源
 */
public class PowerSupplyAdapter implements JapanPowerSupply {

    private CnPowerSupply cnPowerSupply;

    public PowerSupplyAdapter(CnPowerSupply cnPowerSupply) {
        this.cnPowerSupply = cnPowerSupply;
    }

    @Override
    public void connect() {
        cnPowerSupply.connect();
    }

}
