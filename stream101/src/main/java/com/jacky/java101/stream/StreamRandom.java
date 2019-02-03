package com.jacky.java101.stream;

import java.util.Random;

public class StreamRandom {
    public static void main(String[] args) {
        /**
         * java.util.Random
         * public IntStream ints(int randomNumberOrigin, int randomNumberBound)
         * public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound)
         */
//        new Random().ints(1, 2019).forEach(System.out::println); // infinite
        new Random().ints(8, 2000, 2020).forEach(System.out::println);
        new Random().doubles(8, 20, 20.20).forEach(System.out::println);
    }
}
