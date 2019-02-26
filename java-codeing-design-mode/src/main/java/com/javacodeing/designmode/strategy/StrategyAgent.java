package com.javacodeing.designmode.strategy;

/**
 * 策略代理类
 */
public class StrategyAgent {

    private Strategy strategy;

    public StrategyAgent(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.calculate(a, b);
    }

}
