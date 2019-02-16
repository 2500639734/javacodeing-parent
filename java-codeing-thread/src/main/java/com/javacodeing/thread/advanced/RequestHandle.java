package com.javacodeing.thread.advanced;

public class RequestHandle implements Request {

    private Response response;

    /**
     * 模拟请求业务处理
     * @param param
     */
    public RequestHandle (Param param) {
        System.out.printf("模拟网络请求,param = %s\n", param);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Response response = new Response();
        response.setTotalMoney(param.getNum() * param.getMoney());
        this.response = response;
        System.out.printf("网络请求结束\n");
    }

    /**
     * 返回结果
     * @return
     */
    @Override
    public Response getResposne() {
        return this.response;
    }

}
