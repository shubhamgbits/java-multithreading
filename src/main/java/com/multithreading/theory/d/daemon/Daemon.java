package com.multithreading.theory.d.daemon;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Daemon {
    public static void execute(){
        Deque<Event> deque=new ConcurrentLinkedDeque<Event>();
        WriterThread writer=new WriterThread(deque);
        for (int i=0; i< Runtime.getRuntime().availableProcessors();
             i++){
            Thread thread=new Thread(writer);
            thread.start();
        }
        CleanerThread cleaner=new CleanerThread(deque);
        cleaner.start();
    }
}
