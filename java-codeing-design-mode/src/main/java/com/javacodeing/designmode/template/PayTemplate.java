package com.javacodeing.designmode.template;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟用户进行支付模板类
 */
public abstract class PayTemplate {

    /**
     * 模拟支付流程
     * @return
     */
    public PayResponse userPay() {
        // 1.获取用户信息
        User user = getUserInfo();
        // 2.记录支付之前的日志
        beforePayLog(user);
        // 3.调用支付接口,获取支付返回结果
        PayResponse payResponse = pay(user);
        // 4.记录支付之后的日志
        afterPayLog(user, payResponse);
        // 5.返回支付结果
        return payResponse;
    }


    private User getUserInfo() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setPhone("18000000000");
        return user;
    }

    private void beforePayLog(User user) {
        System.out.printf("准备支付,user  = %s\n",user.toString());
    }

    /**
     * 模拟用户支付的方法
     * 业务流程中可能会发生变化的部分(如更换支付方式)推迟到子类中实现
     * @param user
     * @return
     */
    public abstract PayResponse pay(User user);

    private void afterPayLog(User user, PayResponse payResponse) {
        System.out.printf("结束支付,user  = %s, payResponse = %s\n",user.toString(), payResponse.toString());
    }

    private void informUserPayResonse(User user, PayResponse payResponse) {
        System.out.printf("尊敬的%s,您在%s提交的支付请求%s\n",user.getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                payResponse.getMsg());
    }

}
