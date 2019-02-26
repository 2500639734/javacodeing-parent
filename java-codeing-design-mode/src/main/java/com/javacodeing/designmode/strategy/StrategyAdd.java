package com.javacodeing.designmode.strategy;

/**
 * 定义加法策略
 */
public class StrategyAdd implements Strategy {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }

}
