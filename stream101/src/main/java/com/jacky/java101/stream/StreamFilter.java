package com.jacky.java101.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Candy");
        map.put(4, "Dunk");
        map.put(5, "Ella");

        filterMapByValue(map);
        filterMapByKey(map);
        filterMapByPredicate(map);
        filterFindAny(map);
    }

    private static void filterMapByValue(Map<Integer, String> map) {

        // without Stream
        String result = "";
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if ("Bob".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }

        System.out.println(String.format("without stream: %s", result));

        // with stream
        result = map.entrySet()
                .stream()
                .filter(m -> "Bob".equals(m.getValue()))
                .map(m -> m.getValue())
                .collect(Collectors.joining());

        System.out.println(String.format("with stream: %s", result));

        // with stream
        result = map.entrySet()
                .stream()
                .filter(x -> {
                    if (!x.getValue().contains("Bob") && !x.getValue().contains("Dunk")) {
                        return true;
                    }
                    return false;
                })
                .map(m -> m.getValue())
                .collect(Collectors.joining("\t"));

        System.out.println(String.format("with stream example 2: %s", result));
    }

    private static void filterMapByKey(Map<Integer, String> map) {
        Map<Integer, String> collect = map.entrySet()
                .stream()
                .filter(m -> m.getKey() == 3)
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));

        System.out.println(String.format("filter map by key: %s", collect));

        collect = map.entrySet()
                .stream()
                .filter(m -> m.getKey() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(String.format("fitler map by key 2: %s", collect));
    }

    private static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet()
                .stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void filterMapByPredicate(Map<Integer, String> map) {
        System.out.println(filterByValue(map, x -> x.equals("Bob")));
        System.out.println(filterByValue(map, x -> (x.contains("Alice") || x.contains("Ella"))));
        System.out.println(filterByValue(map, x -> x.length() > 3));
    }

    private static void filterFindAny(Map<Integer, String> map) {
        Map.Entry<Integer, String> result = map.entrySet()
                .stream()
                .filter(x -> x.getValue().length() > 3)
                .findAny()
                .orElse(null);
        System.out.println(result.getValue());
    }
}
