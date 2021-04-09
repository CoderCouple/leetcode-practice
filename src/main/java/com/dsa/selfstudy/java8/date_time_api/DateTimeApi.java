package com.dsa.selfstudy.java8.date_time_api;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeApi {

    public static long getFilterFromDays(final Instant instant, final long numDays) {
        Instant theInstant = instant;
        if (theInstant == null) {
            theInstant = Instant.now();
        }
        return theInstant.minus(numDays, ChronoUnit.DAYS).truncatedTo(ChronoUnit.HOURS).toEpochMilli();
    }

    public static void main(String[] args) {
        System.out.println(Instant.now());
        System.out.println(Instant.EPOCH);
        System.out.println(Instant.ofEpochSecond(9961199));
        System.out.println(Duration.between(Instant.EPOCH, Instant.now()).getSeconds());
        System.out.println(Duration.between(Instant.now(),Instant.EPOCH));


        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        System.out.println(LocalDate.parse("2008-04-14", DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDate.of(2020,4,30));
        System.out.println(LocalDate.of(2020, Month.APRIL,30));

        System.out.println(LocalDate.now());

        System.out.println(getFilterFromDays(Instant.now(),7));
    }
}
