package com.javacodeing.designmode.template;

/**
 * 模板方法设计模式
 * 使用场景: 一个完整的业务流程中,有一部分业务流程容易变化
 * 将容易变化的这部分业务流程构象出来,交给具体的子类实现
 */
public class PayTemplateClient {

    public static void main(String[] args) {
        // 模拟使用支付宝支付的业务流程
        PayTemplate zfbPayTemplate = new ZfbPay();
        zfbPayTemplate.userPay();

        // 模拟使用微信支付的业务流程
        PayTemplate wxPayTemplate = new WxPay();
        wxPayTemplate.userPay();

        // 模拟使用美团支付的业务流程,这种使用匿名内部类实现
        PayTemplate mtzfPayTemplate = new PayTemplate() {
            @Override
            public PayResponse pay(User user) {
                System.out.printf("%s使用美团支付进行支付\n", user.getName());
                return PayResponse.buildSuccess(200, "支付成功");
            }
        };
        mtzfPayTemplate.userPay();

    }

}
