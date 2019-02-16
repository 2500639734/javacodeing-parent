package com.javacodeing.designmode.factory.abstraction;

public class FastEngine implements Engine {

    @Override
    public void install() {
        System.out.println("安装转速快的发动机");
    }

}
