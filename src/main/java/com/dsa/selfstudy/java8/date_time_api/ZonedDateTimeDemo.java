package com.dsa.selfstudy.java8.date_time_api;

import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;

public class ZonedDateTimeDemo {

    public static void zonedDateTimeDemo() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime Now : " + zonedDateTime);

        ZoneId zone = ZoneId.of("+05:30");
        ZonedDateTime zonedDateTime1 = zonedDateTime.of(2020, 10, 10, 11, 15, 0, 0, zone);
        System.out.println("ZonedDateTime of India : "  + zonedDateTime1);


        System.out.println(zonedDateTime.getYear());
        System.out.println(zonedDateTime.getMonth());
        System.out.println(zonedDateTime.getMonthValue());
        System.out.println(zonedDateTime.getDayOfWeek());
        System.out.println(zonedDateTime.getDayOfMonth());
        System.out.println(zonedDateTime.getDayOfYear());
        System.out.println(zonedDateTime.getHour());
        System.out.println(zonedDateTime.getMinute());
        System.out.println(zonedDateTime.getSecond());

        System.out.println("Update Month : " + zonedDateTime.withMonth(5));

        System.out.println("Day after Tomorrow : " + zonedDateTime.plus(Period.ofDays(2)));
        System.out.println("Yesterday : " + zonedDateTime.minus(Period.ofDays(1)));

        ZoneOffset mumbaiOffset = ZoneOffset.of("+05:30");
        System.out.println("Mumbai Offset : " + mumbaiOffset);
        System.out.println("Mumbai ZoneId : " + mumbaiOffset.normalized());

    }

    public static void main(String[] args) {
        zonedDateTimeDemo();
    }

}
