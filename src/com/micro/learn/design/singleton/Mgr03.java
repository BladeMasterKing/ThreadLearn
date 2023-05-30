package com.micro.learn.design.singleton;

/**
 * 懒汉式：存在线程安全问题
 */
public class Mgr03 {

    private Mgr03(){}

    private static Mgr03 INSTANCE;

    public static Mgr03 getInstance(){
        if(null == INSTANCE){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void fn(){
        System.out.println("fn");
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
