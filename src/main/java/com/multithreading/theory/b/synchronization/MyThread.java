package com.multithreading.theory.b.synchronization;

public class MyThread implements Runnable{
    private Display display;
    private String name;

    public MyThread(String name, Display display){
        this.name = name;
        this.display = display;
    }

    @Override
    public void run() {
        //display.wish(name);
        //display.syncWish(name);
        //display.syncBlockWish(name);
        display.syncDiffObject(name);
    }
}
