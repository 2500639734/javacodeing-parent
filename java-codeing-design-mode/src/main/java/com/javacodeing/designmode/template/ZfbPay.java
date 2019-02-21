package com.javacodeing.designmode.template;

/**
 * 模拟调用支付宝支付接口进行支付
 */
public class ZfbPay extends PayTemplate {

    @Override
    public PayResponse pay(User user) {
        System.out.printf("%s使用支付宝进行支付\n", user.getName());
        return PayResponse.buildSuccess(200, "支付成功");
    }

}
