package com.javacodeing.designmode.builder;

import lombok.Data;

/**
 * 角色服饰,不同的角色有不同的服饰
 */
@Data
public class RoleDress {

    // 上衣
    private String coat;

    // 裤子
    private String trousers;

    // 鞋子
    private String shoes;

}
