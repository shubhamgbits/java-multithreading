package com.multithreading.theory.b.synchronization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Display {
    /**
     * No Synchronization
     */
    public void wish(String name){
        for (int i=0; i<5; i++){
            System.out.println("Happy birthday "+name);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                log.error("Error Occurred");
            }
        }
    }
    /**
     * Synchronization keyword in method signature
     */
    public synchronized void syncWish(String name){
        for (int i=0; i<5; i++){
            System.out.println("Happy birthday "+name);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                log.error("Error Occurred");
            }
        }
    }
    /**
     * Using synchronized block
     */
    public void syncBlockWish(String name){
        // Works if threads using same instance of the class
        synchronized (this) {
            for (int i=0; i<5; i++){
                System.out.println("Happy birthday "+name);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    log.error("Error Occurred");
                }
            }
        }
    }

    public void syncDiffObject(String name){
        // Works even if threads are using different instance of class
        synchronized (Display.class) {
            for (int i=0; i<5; i++){
                System.out.println("Happy birthday "+name);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    log.error("Error Occurred");
                }
            }
        }
    }
}
