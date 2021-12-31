package com.wyz.designpatterns;

/**
 * Application
 *
 * @author wangyz
 * @date 2021/11/18 18:53
 */
public class Application {

    private Handler diamond60,diamond270,rareDiamond;    //责任链上的对象
    public void createChain(){       //建立责任链
        diamond60=new Diamond60DrawAPrize();
        diamond270=new Diamond270DrawFivePrizes();
        rareDiamond=new RareCrystalOfKings();
        diamond60.setNextHandler(diamond270);
        diamond270.setNextHandler(rareDiamond);
    }
    public void reponseClient(int number){  //响应用户的请求
        diamond60.handleRequest(number);
    }
    public static void main(String args[]){
        Application application = new Application();
        application.createChain();
        System.out.println("当点击“60钻石”抽一次时：");
        System.out.print("[购买成功]");
        application.reponseClient(60);
        System.out.println("---------------------------");
        System.out.println("当点击“270钻石”抽五次时：");
        System.out.print("[购买成功]");
        application.reponseClient(270);
        System.out.println("---------------------------");
        System.out.println("当钻石抽奖“幸运值达201时”：");
        System.out.print("[购买成功]");
        application.reponseClient(201);
    }
}
