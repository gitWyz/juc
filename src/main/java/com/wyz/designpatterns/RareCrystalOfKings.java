package com.wyz.designpatterns;

/**
 * RareCrystalOfKings
 *
 * @author wangyz
 * @date 2021/11/18 18:58
 */
public class RareCrystalOfKings implements Handler{

    // 存放当前处理者后继的Hander接口变量
    private Handler handler;
    @Override
    public void handleRequest(int number){
        //当幸运值满201时，出稀有水晶
        if(number==201){
            System.out.println("【稀有】王者水晶");
        }
        else {
            //将请求传递给下一个处理者
            handler.handleRequest(number);
        }
    }
    @Override
    public void setNextHandler(Handler handler){
        this.handler=handler;
    }
}
