package com.javacodeing.designmode.factory.abstraction;

/**
 * 组装工厂
 */
public interface AssemblyFactory {

    // 组装引擎
    Engine assemblyEngine ();

    // 组装座椅
    Seat assemblySeat();

    // 组装变速器
    Transmission assemblyTransmission();

}
