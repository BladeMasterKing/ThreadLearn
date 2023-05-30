package com.micro.learn.juc.ordering;

import java.io.IOException;

public class L03_ThisEscape {

    private int num;

    public L03_ThisEscape(){
        new Thread(() -> {
            System.out.println(num);
        }).start();
    }

    public static void main(String[] args) throws IOException {
        new L03_ThisEscape();
        System.in.read();
    }
}
