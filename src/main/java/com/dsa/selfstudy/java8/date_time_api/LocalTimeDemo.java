package com.dsa.selfstudy.java8.date_time_api;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {

    public static void main(String[] args) {
        localTimeDemo();
    }

    public static void localTimeDemo() {

        LocalTime now = LocalTime.now();
        System.out.println("Time Now : " + now);

        LocalTime of = LocalTime.of(12, 23,10);
        System.out.println("Time Of: " + of);

        LocalTime time = LocalTime.parse("12-5-30", DateTimeFormatter.ofPattern("HH-m-ss"));
        System.out.println("String Time : " + time);

        System.out.println("Time : " + time);
        System.out.println("Hour : " + time.getHour());
        System.out.println("Minutes : " + time.getMinute());
        System.out.println("Seconds : " + time.getSecond());

        System.out.println("MAX Time : " + LocalTime.MAX);
        System.out.println("MIN Time : " + LocalTime.MIN);
        System.out.println("NOON Time : " + LocalTime.NOON);
        System.out.println("MIDNIGHT Time : " + LocalTime.MIDNIGHT);

        LocalTime startTime = LocalTime.of(9,30,00);
        LocalTime endTime = LocalTime.of(17, 30, 00);

        System.out.println("Is StarTime before endTime : " + startTime.isBefore(endTime));
        System.out.println("Is endTime before startTime : " + endTime.isBefore(startTime));

        System.out.println("Truncated Seconds : " + now.truncatedTo(ChronoUnit.SECONDS));
        System.out.println("Truncated Minutes : " + now.truncatedTo(ChronoUnit.MINUTES));
        System.out.println("Truncated Hour : " + now.truncatedTo(ChronoUnit.HOURS));
    }
}
