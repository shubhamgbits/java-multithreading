package com.multithreading.theory.e.threadgroup;

public class MyThreadGroup extends ThreadGroup{

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %d has thrown an Exception\n", t.threadId());
        e.printStackTrace(System.out);
        System.out.print("Terminating the rest of the Threads\n");
        interrupt();
    }
}
