package com.jacky.java101.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

    public static void main(String[] args) {
        strUpperCase();
        objectToString();
        objectToObject();
    }

    private static void strUpperCase() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "lemon");
        // without Stream
        List<String> fruitUpper = new ArrayList<>();
        for (String s : fruits) {
            fruitUpper.add(s.toUpperCase());
        }

        System.out.println(fruits);
        System.out.println(fruitUpper);

        // with Stream
        List<String> fruitStream = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(fruitStream);

        // extra, streams apply to any data type
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numberStream = numbers.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(numberStream);
    }

    static class Student {
        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }
        private String name;
        private int id;
        public String getName() {
            return name;
        }
        public int getId() {
            return id;
        }
    }

    private static void objectToString() {

        List<Student> students = Arrays.asList(
                new Student("Bob", 1),
                new Student("Alice", 2),
                new Student("Jan", 3)
        );

        // without Stream
        List<String> names = new ArrayList<>();
        for (Student s : students) {
            names.add(s.getName());
        }
        System.out.println(names);

        // with Stream
        names = students.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(names);
    }

    static class Employee {
        public Employee(String name) {
            this.name = name;
        }
        private String name;
        public String getName() {
            return name;
        }
    }

    private static void objectToObject() {
        List<Student> students = Arrays.asList(
                new Student("Bob", 1),
                new Student("Alice", 2),
                new Student("Jan", 3)
        );

        // with Stream
        List<Employee> employees = students.stream().map(x -> {
            Employee e = new Employee("employee: " + x.getName());
            return e;
        }).collect(Collectors.toList());

        employees.stream().map(x -> x.getName()).forEach(System.out::println);
    }
}
