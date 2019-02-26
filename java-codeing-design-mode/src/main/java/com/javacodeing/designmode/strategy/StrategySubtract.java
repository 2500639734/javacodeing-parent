package com.javacodeing.designmode.strategy;

/**
 * 定义减法策略
 */
public class StrategySubtract implements Strategy {

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }

}
