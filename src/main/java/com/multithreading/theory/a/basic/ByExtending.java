package com.multithreading.theory.a.basic;

public class ByExtending extends Thread{
    @Override
    public void run(){
        System.out.println("I am thread: " + Thread.currentThread().getName());
        for (int i = 0; i<10; i++)
            System.out.println("Shyam");
    }
}
