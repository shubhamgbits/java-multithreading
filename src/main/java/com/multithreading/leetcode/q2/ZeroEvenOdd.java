package com.multithreading.leetcode.q2;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int count = 1;
    private boolean zeroturn = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            while(!zeroturn){
                wait();
            }
            printNumber.accept(0);
            zeroturn = false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i=i+2){
            while(zeroturn || count%2 != 0){
                wait();
            }
            printNumber.accept(count);
            zeroturn = true;
            count++;
            notifyAll();
        }

    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i=i+2){
            while(zeroturn || count%2 == 0){
                wait();
            }
            printNumber.accept(count);
            zeroturn = true;
            count++;
            notifyAll();
        }
    }
}