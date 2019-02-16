package com.javacodeing.thread.advanced;

import org.junit.Test;

/**
 * Future模式线程提交测试
 * Future模式: 异步处理,相当于前端ajax异步请求
 * 执行请求逻辑时,等待结果之前不影响其它业务逻辑处理
 * 去除了主函数的等待时间,使原本需要等待的时间段可以用于其它业务逻辑的处理
 */
public class ThreadFutureTest {

    @Test
    public void threadFutureSubmit() throws InterruptedException {
        FutureClient futureClient = new FutureClient();
        Param param = new Param();
        param.setNum(10);
        param.setMoney(199);
        Request request = futureClient.submit(param);
        // 异步提交获取response之前不会影响主程序运行
        System.out.println("模拟主线程执行其它业务逻辑");
        Response response = request.getResposne();
        System.out.printf("请求结果Response = %s\n", response);

        Thread.sleep(3000);
    }

}
