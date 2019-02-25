package com.javacodeing.designmode.appearance;

/**
 * 外观设计模式
 * 作用: 屏蔽系统复杂性,对外提供简单接口操作,简化方法调用
 */
public class AppearanceClient {

    public static void main(String[] args) {
        MsgPush msgPush = new MsgPush();
        msgPush.sendMsg();
    }

}
