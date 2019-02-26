package com.javacodeing.designmode.strategy;

/**
 * 定义抽象策略角色
 */
public interface Strategy {

    /**
     * 定义计算两个数字的方法
     * @param a
     * @param b
     */
    int calculate(int a, int b);

}
