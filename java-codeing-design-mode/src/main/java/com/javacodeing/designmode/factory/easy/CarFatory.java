package com.javacodeing.designmode.factory.easy;

/**
 * 汽车工厂
 */
public class CarFatory {

    /**
     * 生产汽车
     * @param type 汽车类型
     * @return
     */
    public static Car createCar(String type) {
        if ("bmw".equals(type)) {
            return new BmwCar();
        }

        if ("benz".equals(type)) {
            return new BenzCar();
        }

        return null;
    }

}
