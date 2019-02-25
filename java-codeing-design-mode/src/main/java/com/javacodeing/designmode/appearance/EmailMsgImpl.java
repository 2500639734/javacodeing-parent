package com.javacodeing.designmode.appearance;

public class EmailMsgImpl implements EmailMsg {

    @Override
    public void send() {
        System.out.println("邮件推送");
    }

}
