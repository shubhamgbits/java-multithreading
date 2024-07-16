package com.multithreading.theory.f.threadlocal.with;

import com.multithreading.theory.f.threadlocal.without.UnsafeTask;

import java.util.concurrent.TimeUnit;

public class CheckTL {
    public static void execute(){
        SafeTask safeTask = new SafeTask();

        for(int i=0; i<3; i++){
            Thread t = new Thread(safeTask);
            t.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
