package com.micro.learn.juc.ordering;

import java.util.concurrent.CountDownLatch;

public class L01_Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) {

        for(long i = 0; i< Long.MAX_VALUE; i++){
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch latch = new CountDownLatch(2);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;

                latch.countDown();
            });

            t1.start();
            t2.start();

            if(x == 0 && y == 0){
                System.out.println("第"+i+"执行，x = 0，y = 0，");
                System.exit(-1);
            }
        }


    }
}
