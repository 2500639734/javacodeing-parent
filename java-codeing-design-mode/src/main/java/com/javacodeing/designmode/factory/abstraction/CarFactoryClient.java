package com.javacodeing.designmode.factory.abstraction;


/**
 * 抽象工厂测试
 * 用来生产不同产品族的全部产品,不支持扩展增加产品,支持增加产品族
 */
public class CarFactoryClient {

    public static void main(String[] args) {
        AssemblyFactory bmwCarFactory = new BmwCarFactory();
        Engine bmwEngine = bmwCarFactory.assemblyEngine();
        bmwEngine.install();
        Seat bmwSeat = bmwCarFactory.assemblySeat();
        bmwSeat.install();
        Transmission bmwTransmission = bmwCarFactory.assemblyTransmission();
        bmwTransmission.install();
    }

}
