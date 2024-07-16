package com.multithreading.problems.q1;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FileReadingTheory {

    public static void useScanner(){
/*
    Reading the file from the resources folder using getResourceAsStream
*/
        Optional<InputStream> inputStreamOptional = Optional.ofNullable(
                FileReadingTheory.class.getResourceAsStream("/files/file4.txt")
        );

        if(inputStreamOptional.isPresent()){
            Scanner scanner = new Scanner(inputStreamOptional.get(), StandardCharsets.UTF_8);
/*
    scanner.useDelimiter("\\A").next(): This sets the delimiter for the Scanner to \\A,
    which is a regex pattern that matches the beginning of the input.
    This effectively tells the Scanner to read the entire content of the InputStream as a single token.
    The next() method then reads and returns this token as a String.
*/
            String content = scanner.useDelimiter("\\A").next();

            System.out.println(content);
        }
    }

    public static void useBufferedReader(){
/*
        First step remains same. Reading from inputStream
 */
        Optional<InputStream> inputStreamOptional = Optional.ofNullable(
                FileReadingTheory.class.getResourceAsStream("/files/file1.txt")
        );

        if(inputStreamOptional.isPresent()){
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamOptional.get(), StandardCharsets.UTF_8));

            String content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println(content);
        }
    }

    public static void usePath(){
        try{
            URI uri = Objects.requireNonNull(FileReadingTheory.class.getResource("/files/file1.txt")).toURI();
            Path path = Paths.get(uri);
            try(Stream<String> lines = Files.lines(path)){
                String content = lines.collect(Collectors.joining(System.lineSeparator()));
                System.out.println(content);
            }
        }
        catch (URISyntaxException | IOException e){
            log.error("Error Occurred");
        }
    }
}
