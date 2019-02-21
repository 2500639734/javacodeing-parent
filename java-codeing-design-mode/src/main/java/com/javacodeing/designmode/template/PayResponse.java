package com.javacodeing.designmode.template;

import lombok.Data;

/**
 * 模拟支付返回结果包装类
 */
@Data
public class PayResponse {

    private int code;

    private String msg;

    public PayResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static PayResponse buildSuccess(int code, String msg) {
        return new PayResponse(code, msg);
    }

    public static PayResponse buildFailure(int code, String msg) {
        return new PayResponse(code, msg);
    }

}
