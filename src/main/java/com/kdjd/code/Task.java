package com.kdjd.code;

import java.util.Date;

public class Task {


    public static void main(String[] args) {


        Runnable t = () -> {
            while (true) {
                System.out.println(new Date());
                System.out.println("=======");
                System.out.println(new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        new Thread(t).start();
    }

}
