package com.wyz.designpatterns;

/**
 * Diamond60DrawAPrize
 *
 * @author wangyz
 * @date 2021/11/18 18:55
 */
public class Diamond60DrawAPrize implements Handler{
    //存放当前处理者后继的Hander接口变量
    private Handler handler;
    @Override
    public void handleRequest(int number){
        //60钻石抽一次
        if(number==60){
            String random = "";
            String[] doc = {"白起", "夏侯惇", "甄姬", "金币288","小喇叭5","铭文碎片1600", "铭文碎片400","铭文碎片100", "铭文碎片25", "爱心气球（3日）", "亲密玫瑰","钻石48","龙域领主体验卡"};
            //随机选取其一输出
            int index = (int) (Math.random() * doc.length);
            random = doc[index];
            System.out.println(random);
        }
        else
            //将请求传递给下一个处理者
        {
            handler.handleRequest(number);
        }
    }
    @Override
    public void setNextHandler(Handler handler){
        this.handler=handler;
    }
}
