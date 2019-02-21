package com.javacodeing.designmode.builder;

/**
 * 建造盲僧-李青角色服饰
 */
public class LeeSinRoleDressBuilder implements RoleDressBuilder {

    private RoleDress roleDress;

    public LeeSinRoleDressBuilder() {
        roleDress = new RoleDress();
    }

    @Override
    public void buildCoat() {
        roleDress.setCoat("沙滩衬衫");
    }

    @Override
    public void buildTrousers() {
        roleDress.setTrousers("沙滩裤");
    }

    @Override
    public void buildShoes() {
        roleDress.setShoes("人字拖");
    }

    @Override
    public RoleDress buildRoleDress() {
        return roleDress;
    }

}
