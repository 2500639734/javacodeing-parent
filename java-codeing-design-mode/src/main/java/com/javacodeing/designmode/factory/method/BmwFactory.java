package com.javacodeing.designmode.factory.method;

/**
 * 宝马汽车工厂
 */
public class BmwFactory implements CarFactory {

    @Override
    public Car createCar(String type) {
        if ("bmw3".equals(type)) {
            // 生产宝马3系
         return new Bmw3Car();
        }

        if ("bmw5".equals(type)) {
            // 生产宝马5系
            return new Bmw5Car();
        }
        return null;
    }
}
