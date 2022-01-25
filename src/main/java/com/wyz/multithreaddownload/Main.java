package com.wyz.multithreaddownload;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author zsh
 * @site www.qqzsh.top
 * @company wlgzs
 * @create 2019-05-27 9:03
 * @description 主线程启动入口
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件的地址，按ENTER结束");
        String downpath = scanner.nextLine();
        System.out.println("下载的文件名及路径为："+ MultiPartDownLoad.downLoad(downpath));
        try {
            System.out.println("下载完成，本窗口5s之后自动关闭");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
