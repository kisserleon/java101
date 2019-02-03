package com.jacky.java101.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile {

    public static void main(String[] args) {

        // eg 1
        String fileName = "lines.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


        // eg 2
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);

        // eg 3
        list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);

        // eg 4
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // eg 5
        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
