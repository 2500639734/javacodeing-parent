package com.javacodeing.designmode.appearance;

public class SmsMsgImpl implements SmsMsg {

    @Override
    public void send() {
        System.out.println("短信推送");
    }

}
