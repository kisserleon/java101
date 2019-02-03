package com.jacky.java101.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Java Date Time APIs
 * In old days, we use the following classic Date and Calendar APIs to represent and manipulate date.
 *
 * java.util.Date – date and time, print with default time-zone.
 * java.util.Calendar – date and time, more methods to manipulate date.
 * java.text.SimpleDateFormat – formatting (date -> text), parsing (text -> date) for date and calendar.
 * In Java 8, a new series of date and time APIs (JSR310 and inspired by Joda-time) are created in the new java.time package.
 *
 * java.time.LocalDate – date without time, no time-zone.
 * java.time.LocalTime – time without date, no time-zone.
 * java.time.LocalDateTime – date and time, no time-zone.
 * java.time.ZonedDateTime – date and time, with time-zone.
 * java.time.DateTimeFormatter – formatting (date -> text), parsing (text -> date) for java.time
 * java.time.Instant – date and time for machine, seconds passed since the Unix epoch time (midnight of January 1, 1970 UTC)
 * java.time.Duration – Measures time in seconds and nanoseconds.
 * java.time.Period – Measures time in years, months and days.
 * java.time.TemporalAdjuster – Adjust date.
 */
public class ZoneList {

    public static void main(String[] argv) {

        Map<String, String> sortedMap = new LinkedHashMap<>();

        List<String> zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());

        //Get all ZoneIds
        Map<String, String> allZoneIds = getAllZoneIds(zoneList);

        //sort map by key
        /*allZoneIds.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));*/

        //sort by value, descending order
        allZoneIds.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue().reversed())
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

        // print map
        sortedMap.forEach((k, v) ->
        {
            String out = String.format("%35s (UTC%s) %n", k, v);
            System.out.printf(out);
        });

        System.out.println("\nTotal Zone IDs " + sortedMap.size());

    }

    private static Map<String, String> getAllZoneIds(List<String> zoneList) {

        Map<String, String> result = new HashMap<>();

        LocalDateTime dt = LocalDateTime.now();

//        for (String zoneId : zoneList) {
//
//            ZoneId zone = ZoneId.of(zoneId);
//            ZonedDateTime zdt = dt.atZone(zone);
//            ZoneOffset zos = zdt.getOffset();
//
//            //replace Z to +00:00
//            String offset = zos.getId().replaceAll("Z", "+00:00");
//
//            result.put(zone.toString(), offset);
//
//        }

        zoneList
                .stream()
                .map(x -> ZoneId.of(x))
                .collect(Collectors.toMap(x -> x, x -> LocalDateTime.now().atZone(x).getOffset().getId().replaceAll("Z", "+00:00")))
                .entrySet()
                .stream()
                .forEach(e -> result.put(e.getKey().toString(), e.getValue()));

        return result;

    }
}
