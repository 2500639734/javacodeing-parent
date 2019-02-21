package com.javacodeing.designmode.builder;

/**
 * 组装构建人物角色服饰
 */
public class RoleDressDirector {

    /**
     * 构建角色服饰
     * @param roleDressBuilder
     * @return
     */
    public RoleDress createRoleDress(RoleDressBuilder roleDressBuilder) {
        // 建造角色上衣
        roleDressBuilder.buildCoat();
        // 建造角色裤子
        roleDressBuilder.buildTrousers();
        // 建造角色鞋子
        roleDressBuilder.buildShoes();
        // 组装建造完整角色服饰返回
        return roleDressBuilder.buildRoleDress();
    }

}
