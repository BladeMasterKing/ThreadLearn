package com.micro.learn.design.singleton;

/**
 * Double Check Lock
 */
public class Mgr06 {

    private static Mgr06 INSTANCE;

    private Mgr06(){}

    public static Mgr06 getInstance(){
        if(null == INSTANCE){
            synchronized(Mgr06.class){
                if(null == INSTANCE){
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
