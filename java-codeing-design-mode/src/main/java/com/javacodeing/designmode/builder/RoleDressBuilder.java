package com.javacodeing.designmode.builder;

/**
 * 建造角色服饰的接口
 */
public interface RoleDressBuilder {

    // 建造上衣
    void buildCoat();

    // 建造裤子
    void buildTrousers();

    // 建造鞋子
    void buildShoes();

    // 组装角色服饰
    RoleDress buildRoleDress();

}
