package com.multithreading.theory.f.threadlocal.without;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
public class UnsafeTask implements Runnable{
    private LocalDateTime startDate;


    @Override
    public void run() {
        startDate = LocalDateTime.now();
        log.info("Starting thread: {} :: {}", Thread.currentThread().threadId(), startDate);
        try {
            TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().threadId(),startDate);
    }
}
