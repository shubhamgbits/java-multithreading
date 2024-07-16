package com.multithreading.theory.d.daemon;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WriterThread implements Runnable{

    private Deque<Event> deque;
    public WriterThread (Deque<Event> deque){
        this.deque=deque;
    }
    @Override
    public void run() {
        for (int i=1; i<100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getName()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("Interrupted Exception");
            }
        }
    }
}
