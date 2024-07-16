package com.multithreading.theory.c.communication;


public class CommunicationUsage {
    public static final Object lock = new Object();
    public static int count = 1;

    public static void print(){
        Thread even = new Thread(new PrinterThread(true), "Even Thread");
        Thread odd = new Thread(new PrinterThread(false), "Odd Thread");

        even.start();
        odd.start();
    }
}
