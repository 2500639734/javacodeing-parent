package com.javacodeing.designmode.factory.method;

/**
 * 汽车工厂
 */
public interface CarFactory {

    /**
     * 创建对应型号的汽车
     * @param type
     * @return
     */
    public Car createCar (String type);

}
