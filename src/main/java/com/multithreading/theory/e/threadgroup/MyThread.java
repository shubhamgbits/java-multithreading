package com.multithreading.theory.e.threadgroup;

import java.util.Random;

public class MyThread implements Runnable{
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().threadId());
        while (true) {
            result = 1000 / ((int) (random.nextDouble() * 1000000000));
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%s : Interrupted\n", Thread.currentThread().threadId());
                return;
            }
        }
    }
}
