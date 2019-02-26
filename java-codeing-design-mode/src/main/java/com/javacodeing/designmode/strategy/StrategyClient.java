package com.javacodeing.designmode.strategy;

/**
 * 策略模式
 * 抽象一组算法或功能,能够在不影响客户端调用的情况下替换
 * 如果策略过多,实现类也会过多
 */
public class StrategyClient {

    public static void main(String[] args) {
        // 使用加法策略
        StrategyAgent strategyAgentAdd = new StrategyAgent(new StrategyAdd());
        System.out.println(strategyAgentAdd.calculate(20, 10));

        // 使用减法策略
        StrategyAgent strategyAgentSubtract = new StrategyAgent(new StrategySubtract());
        System.out.println(strategyAgentSubtract.calculate(20, 10));
    }

}
