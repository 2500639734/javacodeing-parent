package com.javacodeing.designmode.template;

/**
 * 模拟调用微信支付接口进行支付
 */
public class WxPay extends PayTemplate {

    @Override
    public PayResponse pay(User user) {
        System.out.printf("%s使用微信进行支付\n", user.getName());
        return PayResponse.buildSuccess(200, "支付成功");
    }

}
