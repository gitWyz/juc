package com.wyz.designpatterns;

/**
 * Handler
 *
 * @author wangyz
 * @date 2021/11/18 18:54
 */
public interface Handler {
    void handleRequest(int number);   //具体处理用户请求60钻石抽一次还是270钻石抽五次
    void setNextHandler(Handler handler);
}
