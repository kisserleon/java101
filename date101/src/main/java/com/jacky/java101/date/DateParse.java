package com.jacky.java101.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateParse {
    public static void main(String[] args) {

        // The ‘Z’ suffix means UTC, you can convert into a java.time.instant directly, then display it with a time zone.
        parseStrDate("2016-08-16T15:23:01Z");

        // 2011-12-03T10:15:30+01:00' or '2011-12-03T10:15:30+01:00[Europe/Paris]'
        zonedDateTime("2016-08-16T10:15:30+08:00");
//        zonedDateTime("2018-11-18T10:15:11"); // not work
        zonedDateTime("2011-12-03T10:15:30+01:00[Europe/Paris]");
    }

    private static void zonedDateTime(String date) {
        ZonedDateTime result = ZonedDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        System.out.println("ZonedDateTime : " + result);

        System.out.println("TimeZone : " + result.getZone());

        LocalDate localDate = result.toLocalDate();

        System.out.println("LocalDate : " + localDate);
    }

    private static void parseStrDate(String dateInString) {
        Instant instant = Instant.parse(dateInString);

        System.out.println("Instant : " + instant);

        //get date time only
        LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

        //get localdate
        System.out.println("LocalDate : " + result.toLocalDate());

        //get date time + timezone
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);

        //get date time + timezone
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
        System.out.println(zonedDateTime2);
    }

}