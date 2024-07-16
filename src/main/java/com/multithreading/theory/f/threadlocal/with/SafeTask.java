package com.multithreading.theory.f.threadlocal.with;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SafeTask implements Runnable{
    private static ThreadLocal<LocalDateTime> startDate = new ThreadLocal<LocalDateTime>();

    protected LocalDateTime initialValue(){
        return LocalDateTime.now();
    }


    @Override
    public void run() {
        startDate.set(initialValue());
        log.info("Starting thread: {} :: {}", Thread.currentThread().threadId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().threadId(),startDate.get());
    }
}
