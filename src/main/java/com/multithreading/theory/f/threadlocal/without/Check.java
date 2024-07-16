package com.multithreading.theory.f.threadlocal.without;

import java.util.concurrent.TimeUnit;

public class Check {
    public static void checkWithoutThreadLocal(){
        UnsafeTask unsafeTask = new UnsafeTask();

        for(int i=0; i<3; i++){
            Thread t = new Thread(unsafeTask);
            t.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
