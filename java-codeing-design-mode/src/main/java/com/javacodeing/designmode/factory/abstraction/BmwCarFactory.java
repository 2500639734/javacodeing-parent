package com.javacodeing.designmode.factory.abstraction;

/**
 * 宝马汽车工厂
 */
public class BmwCarFactory implements AssemblyFactory {

    @Override
    public Engine assemblyEngine() {
        // 使用快速发动机
        return new FastEngine();
    }

    @Override
    public Seat assemblySeat() {
        // 使用自动加热座椅
        return new AutomaticHeatingSeat();
    }

    @Override
    public Transmission assemblyTransmission() {
        // 使用自动挡
        return new AutomaticTransmission();
    }

}
