package com.dsa.selfstudy.java8.date_time_api;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ClockExample {

    public static void clockExample1(){

        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.APRIL, 30, 11, 04,50, 340 *1000000);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();

        Clock clock = Clock.fixed(instant,ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        System.out.println(dt1);
        LocalDateTime dt2 = LocalDateTime.now();
        System.out.println(dt2);

    }

    public static void clockExample2(){

    }

    public static void main(String[] args) {
        clockExample1();

    }
}
