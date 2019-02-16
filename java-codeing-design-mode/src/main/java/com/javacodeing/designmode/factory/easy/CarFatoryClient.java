package com.javacodeing.designmode.factory.easy;

/**
 * 简单工厂模式测试
 * 用来生产同一等级结构中的任意产品(不支持扩展增加产品)
 * 解耦,但工厂职责过重,类型分类过多时会难以维护
 */
public class CarFatoryClient {

    public static void main(String[] args) {
        Car bmwCar = CarFatory.createCar("bmw");
        bmwCar.run();

        Car benzCar = CarFatory.createCar("benz");
        benzCar.run();
    }

}
