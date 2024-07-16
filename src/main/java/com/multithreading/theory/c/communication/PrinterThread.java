package com.multithreading.theory.c.communication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrinterThread implements Runnable{
    private final Boolean isEvenThread;
    public PrinterThread(Boolean isEvenThread){
        this.isEvenThread = isEvenThread;
    }


    @Override
    public void run() {
        while(CommunicationUsage.count <= 100){
            synchronized (CommunicationUsage.lock){
                // If counter is even and current thread not even thread => go to waiting state
                // AND if counter is odd and current thread not odd => Go to waiting state
                if ((CommunicationUsage.count%2==0) != isEvenThread){
                    try {
                        CommunicationUsage.lock.wait();
                    }
                    catch (InterruptedException e){
                        log.error("Error");
                    }
                }

                if(CommunicationUsage.count <= 100){
                    System.out.println(Thread.currentThread().getName() + " - " + CommunicationUsage.count);
                    CommunicationUsage.count++;
                    CommunicationUsage.lock.notifyAll();
                }
            }
        }
    }
}
