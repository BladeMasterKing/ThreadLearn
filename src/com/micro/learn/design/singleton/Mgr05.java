package com.micro.learn.design.singleton;

public class Mgr05 {

    private static Mgr05 INSTANCE;

    private Mgr05(){}

    public static Mgr05 getInstance(){
        if(null == INSTANCE){
            synchronized(Mgr05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void fn(){
        System.out.println("fn is run");
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
