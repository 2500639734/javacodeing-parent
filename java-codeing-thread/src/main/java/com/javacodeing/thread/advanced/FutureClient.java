package com.javacodeing.thread.advanced;

/**
 * 模拟Future模式客户端请求
 */
public class FutureClient {

    public Request submit(Param param) {
        FutureRequest futureRequest = new FutureRequest();
        new Thread(() -> {
            // 阻塞等待执行完毕
            RequestHandle requestHandle = new RequestHandle(param);
            futureRequest.setRequestHandle(requestHandle);
        }).start();
        return futureRequest;
    }

}
