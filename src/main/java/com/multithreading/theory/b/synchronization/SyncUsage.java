package com.multithreading.theory.b.synchronization;

public class SyncUsage {
    public static void usingCommonObject(){
        Display d = new Display();
        Thread t1 = new Thread(new MyThread("Shubham", d));
        Thread t2 = new Thread(new MyThread("Parul", d));

        t1.start();
        t2.start();
    }

    public static void usingDiffObject(){
        Thread t1 = new Thread(new MyThread("Shubham", new Display()));
        Thread t2 = new Thread(new MyThread("Parul", new Display()));

        t1.start();
        t2.start();
    }
}
