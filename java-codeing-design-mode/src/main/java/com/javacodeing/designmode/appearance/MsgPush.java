package com.javacodeing.designmode.appearance;

public class MsgPush {

    private SmsMsg smsMsg;
    private EmailMsg emailMsg;
    private WxMsg wxMsg;

    public MsgPush () {
        smsMsg = new SmsMsgImpl();
        emailMsg = new EmailMsgImpl();
        wxMsg = new WxMsgImpl();
    }

    // 消息推送
    public void sendMsg () {
        smsMsg.send();
        emailMsg.send();
        wxMsg.send();
    }

}
