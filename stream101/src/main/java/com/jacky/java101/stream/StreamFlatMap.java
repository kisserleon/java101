package com.jacky.java101.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFlatMap {
    public static void main(String[] args) {
        /**
         * Stream<String[]>		-> flatMap ->	Stream<String>
         * Stream<Set<String>>	-> flatMap ->	Stream<String>
         * Stream<List<String>>	-> flatMap ->	Stream<String>
         * Stream<List<Object>>	-> flatMap ->	Stream<Object>
         *
         * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
         *
         * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
         */

        twoDArrray();
        flatSet();
        flatPrimitive();
        flatStringArr();
    }

    private static void twoDArrray() {
        String[][] matrix = new String[][]{{"1", "2"}, {"3", "4"}, {"5", "6"}};
        Stream<String[]> s = Arrays.stream(matrix);
        Stream<String> si = s.flatMap(x -> Arrays.stream(x));
        si.filter(x -> "3".equals(x))
                .forEach(System.out::println);
    }

    private static void flatSet() {
        Set<String> carSet = new HashSet<>();
        carSet.add("Peugot");
        carSet.add("Mazda");
        carSet.add("Benz");
        carSet.add("Lexus");
        carSet.add("Volvo");

        Set<String> fruitSet = new HashSet<>();
        fruitSet.add("Apple");
        fruitSet.add("Banana");
        fruitSet.add("Grape");
        fruitSet.add("Avocado");

        List<Set<String>> mylist = new ArrayList<>();
        mylist.add(carSet);
        mylist.add(fruitSet);

        List<String> collect = mylist.stream()
                .flatMap(x -> x.stream())
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void flatPrimitive() {
        int[] intArray = {1, 2, 3, 4, 5, 6};
        Stream<int[]> s = Stream.of(intArray);
        s.flatMapToInt(x -> Arrays.stream(x))
                .forEach(System.out::println);
    }

    private static void flatStringArr() {
        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"d", "e", "f"};
        String[] s3 = new String[]{"g", "h", "i"};

        //join object type array
        String[] result = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(result));
    }

    private static void flatConcat() {
        int [] int1 = new int[]{1,2,3};
        int[] int2 = new int[]{4,5,6};

        //join 2 primitive type array
        int[] result2 = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();
    }
}
