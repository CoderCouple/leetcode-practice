package com.dsa.selfstudy.java8.date_time_api;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {

    public static void main(String[] args) {

        localDateTimeDemo();
    }

    public static void localDateTimeDemo() {

        LocalDateTime dt1 = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println("DateTime Now : "+dt1);

        LocalDateTime dt2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("DateTime Of : " + dt2);

        LocalDateTime dt3 = LocalDateTime.parse("2020/04/30T11:04:00", DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss"));
        // https://stackoverflow.com/a/56508200/8991998
        System.out.println("LocalDateTime from String " + dt3);

        System.out.println("LocalDate : " + dt1.toLocalDate());
        System.out.println("LocalTime : " + dt1.toLocalTime());

        System.out.println("Day : " + dt1.getDayOfMonth());
        System.out.println("Month : " + dt1.getMonth());
        System.out.println("Year : " + dt1.getYear());
        System.out.println("Hour : " + dt1.getHour());
        System.out.println("Minute : " + dt1.getMinute());
        System.out.println("Seconds : " + dt1.getSecond());

        LocalDateTime updatedDate = dt1.withDayOfMonth(28).withYear(1987).withMonth(07);
        // All datetime classes are immutable.
        System.out.println(updatedDate);

        LocalDateTime dt5 = updatedDate.plusDays(92).plus(2, ChronoUnit.YEARS);
        System.out.println(dt5);
    }
}
