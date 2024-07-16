package com.multithreading.problems.q1;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
public class Q1Usage {
    public static void execute(){
//        System.out.println(readFileContents("file1.txt"));
        List<String> inputFiles = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
        String outputFile = "merged_output.txt";
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(inputFiles.size());
        try(FileWriter fileWriter = new FileWriter(outputFile)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            inputFiles.parallelStream().forEach(file->{
                executor.execute(new FileHandleThread(file, bufferedWriter, latch));
            });
            latch.await();
            bufferedWriter.close();
        }
        catch (IOException | InterruptedException e){
            log.error("Error Occurred");
        }
        finally {
            executor.close();
        }
        log.info("File Merging Completed");
    }

    public static String readFileContents(String location){
        Optional<InputStream> inputStreamOptional = Optional.ofNullable(
                Q1Usage.class.getResourceAsStream("/files/"+location)
        );

        if(inputStreamOptional.isPresent()){
            InputStreamReader isr = new InputStreamReader(inputStreamOptional.get(), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }

    public static void writeFile(BufferedWriter bw, String content){


        try{
//            fileWriter.write(content);
//            fileWriter.write();
//            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.newLine();
//            bw.close();
        }
        catch (IOException e){
            log.error("Error Occurred");
        }
        log.info("Write successful");
    }
}
