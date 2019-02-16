package com.javacodeing.designmode.factory.method;

/**
 * 奔驰汽车工厂
 */
public class BenzCarFactory implements CarFactory {

    @Override
    public Car createCar(String type) {
        if ("benzE".equals(type)) {
            // 生产奔驰E系
            return new BenzECar();
        }

        if ("benzG".equals(type)) {
            // 生产奔驰G系
            return new BenzGCar();
        }

        return null;
    }

}
