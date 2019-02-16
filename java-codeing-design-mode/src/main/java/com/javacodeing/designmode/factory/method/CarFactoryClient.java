package com.javacodeing.designmode.factory.method;

/**
 * 测试工厂方法模式
 * 用来生产同一等级结构中的固定产品,支持扩展增加产品
 * 汽车工厂不再负责具体的汽车生产,而是只负责定义生产汽车的方法,降低了汽车工厂的职责
 * 具体汽车型号的生产交给各个品牌的汽车工厂,互相隔离,分类相比简单工厂更细
 */
public class CarFactoryClient {

    public static void main(String[] args) {
        CarFactory bmwCarFactory = new BmwFactory();

        Car bmw3 = bmwCarFactory.createCar("bmw3");
        bmw3.run();

        Car bmw5 = bmwCarFactory.createCar("bmw5");
        bmw5.run();

        CarFactory benzCarFactory = new BenzCarFactory();

        Car benzE = benzCarFactory.createCar("benzE");
        benzE.run();

        Car benzG = benzCarFactory.createCar("benzG");
        benzG.run();

    }

}
