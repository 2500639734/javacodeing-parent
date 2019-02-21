package com.javacodeing.designmode.builder;

/**
 * 建造探险家-伊泽瑞尔角色服饰
 */
public class EzrealRoleDressBuilder implements RoleDressBuilder {

    private RoleDress roleDress;

    public EzrealRoleDressBuilder() {
        roleDress = new RoleDress();
    }

    @Override
    public void buildCoat() {
        roleDress.setCoat("探险家皮夹克");
    }

    @Override
    public void buildTrousers() {
        roleDress.setTrousers("探险家皮裤");
    }

    @Override
    public void buildShoes() {
        roleDress.setShoes("探险家皮鞋");
    }

    @Override
    public RoleDress buildRoleDress() {
        return roleDress;
    }

}
