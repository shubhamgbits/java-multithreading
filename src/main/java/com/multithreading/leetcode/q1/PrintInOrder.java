package com.multithreading.leetcode.q1;

import java.util.concurrent.CountDownLatch;

class PrintInOrder {

    private final CountDownLatch secondLatch = new CountDownLatch(1);
    private final CountDownLatch thirdLatch = new CountDownLatch(1);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    class ThreadPrinter implements Runnable {

        private int threadNo;
        private PrintInOrder printInOrder;

        public ThreadPrinter(int no){
            this.threadNo = no;
            this.printInOrder = new PrintInOrder();
        }

        @Override
        public void run() {

        }
    }
}
