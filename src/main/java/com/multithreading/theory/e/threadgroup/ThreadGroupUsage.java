package com.multithreading.theory.e.threadgroup;

public class ThreadGroupUsage {
    public static void execute(){
        int numberOfThreads = 2 * Runtime.getRuntime()
                .availableProcessors();

        MyThreadGroup threadGroup=new MyThreadGroup("MyThreadGroup");

        MyThread myThread = new MyThread();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread t = new Thread(threadGroup, myThread);
            t.start();
        }

        System.out.printf("Number of Threads: %d\n",
                threadGroup.activeCount());
        System.out.print("Information about the Thread Group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(),
                    threads[i].getState());
        }
    }
}
