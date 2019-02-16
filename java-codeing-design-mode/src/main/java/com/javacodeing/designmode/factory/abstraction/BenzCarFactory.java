package com.javacodeing.designmode.factory.abstraction;

/**
 * 奔驰汽车工厂
 */
public class BenzCarFactory implements AssemblyFactory {

    @Override
    public Engine assemblyEngine() {
        // 使用慢速发送机
        return new SlowEngine();
    }

    @Override
    public Seat assemblySeat() {
        // 使用儿童安全座椅
        return new ChildSafetySeat();
    }

    @Override
    public Transmission assemblyTransmission() {
        // 使用手动档
        return new ManualTransmission();
    }
}
