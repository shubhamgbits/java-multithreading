package com.multithreading.problems.q1;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class FileWritingTheory {
    public static void usingBufferedReader(){
        String content = "Hello, this is some content to write to the file.";
        try(FileWriter fileWriter = new FileWriter("output.txt", StandardCharsets.UTF_8, true)){
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.newLine();
            bw.write(content);
            bw.newLine();
            bw.close();
        }
        catch (IOException e){
            log.error("Error Occurred");
        }
        log.info("Write successful");
    }
}
