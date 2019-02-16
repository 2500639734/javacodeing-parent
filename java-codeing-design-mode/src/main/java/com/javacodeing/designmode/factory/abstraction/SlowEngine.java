package com.javacodeing.designmode.factory.abstraction;

public class SlowEngine implements Engine {

    @Override
    public void install() {
        System.out.println("安装转速慢的发动机");
    }

}
