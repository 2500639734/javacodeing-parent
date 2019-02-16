package com.javacodeing.thread.advanced;

public class FutureRequest implements Request {

    // 请求执行结果 : true 执行完毕, false 未执行完毕
    private boolean FINISH = false;

    // 请求处理类
    private RequestHandle requestHandle;

    /**
     * 设置返回结果
     * @param requestHandle
     */
    public synchronized void setRequestHandle(RequestHandle requestHandle){
        // 获取到结果直接返回
        /*if(FINISH) {
            return;
        }*/

        // 设置结果唤醒
        FINISH = true;
        this.requestHandle = requestHandle;
        notify();
    }

    /**
     * 获取返回结果
     * @return
     */
    @Override
    public synchronized Response getResposne() {
        while (!FINISH) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requestHandle.getResposne();
    }

}
