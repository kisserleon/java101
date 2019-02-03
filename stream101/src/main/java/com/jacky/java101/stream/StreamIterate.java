package com.jacky.java101.stream;

import java.util.stream.Stream;

/**
 * In Java 8, we can use Stream.iterate to create stream values on demand, so called infinite stream.
 */
public class StreamIterate {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(x -> System.out.println(x));

        Stream.iterate(0, n -> n + 1)
                .filter(x -> x % 2 != 0) // odd
                .limit(10)
                .forEach(x -> System.out.println(x));

        fib();
        fib_sum();
        stream9();
    }

    private static void fib() {
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> System.out.println(x));
    }

    private static void fib_sum() {
        int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> n[0])
                .mapToInt(x -> x)
                .sum();
        System.out.println("Fibonacci 10 sum: " + sum);
    }

    /**
     * stream.iterate was enhanced in Java 9. It supports a predicate (condition) as second argument, and the stream.iterate will stop if the predicate is false.
     */
    private static void stream9() {
        Stream.iterate(1, n -> n < 20, n -> n * 2)
                .forEach(x -> System.out.println(x));
    }
}
