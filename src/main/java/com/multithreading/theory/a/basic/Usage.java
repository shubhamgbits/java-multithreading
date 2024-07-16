package com.multithreading.theory.a.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Usage {
    public static void useThread(){
        ByExtending t1 = new ByExtending();
        ByExtending t2 = new ByExtending();
        t1.setName("Thread 1"); t2.setName("Thread 2");
        t1.start();
        t2.start();
    }

    public static void joinExample() {
        ByExtending t1 = new ByExtending();
        t1.start();

        try{
            t1.join(); // Main thread go to waiting stage till t1 is completely executed
        }
        catch (InterruptedException e){
            log.error("Error Occurred");
        }

        for(int i = 0; i<10; i++)
            System.out.println("Ram");

    }
}
