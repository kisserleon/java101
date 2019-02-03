package com.jacky.java101.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamAny {

    public static void main(String[] args) {

        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Java 8
        boolean result = IntStream.of(number).anyMatch(x -> x == 4);

        long[] lNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean result2 = LongStream.of(lNumber).anyMatch(x -> x == 10);

        String[] alphabet = new String[]{"A", "B", "C"};
        result = Arrays.stream(alphabet).anyMatch("A"::equals);


        // IntStream.of or Arrays.stream, same output
        //List<Integer> list = IntStream.of(number).boxed().collect(Collectors.toList());

        List<Integer> list = Arrays.stream(number).boxed().collect(Collectors.toList());

        String password = "password123";

        password.chars() //IntStream
                .mapToObj(x -> (char) x)//Stream<Character>
                .forEach(System.out::println);


    }
}
