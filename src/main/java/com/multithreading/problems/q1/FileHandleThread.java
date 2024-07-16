package com.multithreading.problems.q1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class FileHandleThread implements Runnable{
    private final String inputFile;
    private final BufferedWriter bufferedWriter;
    private final CountDownLatch countDownLatch;

    public FileHandleThread(String inputFile, BufferedWriter fileWriter, CountDownLatch countDownLatch){
        this.inputFile = inputFile;
        bufferedWriter = fileWriter;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        Optional<String> fileContentsOptional = Optional.ofNullable(
                Q1Usage.readFileContents(inputFile)
        );
        synchronized (bufferedWriter){
            fileContentsOptional.ifPresent(s -> {
                try {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        countDownLatch.countDown();
    }
}
