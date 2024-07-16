package com.multithreading.leetcode.q1;

import java.util.concurrent.CountDownLatch;

class UsingCountdownLatch {

    private final CountDownLatch secondLatch = new CountDownLatch(1);
    private final CountDownLatch thirdLatch = new CountDownLatch(1);

    public UsingCountdownLatch() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        secondLatch.await();
        printSecond.run();
        thirdLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        thirdLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
