package com.dsa.selfstudy.java8.date_time_api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo {

    public static void demoLocalDateTime(){

        System.out.println("<------- LocalDate Demo Start-------->");
        LocalDate date1 = LocalDate.now();
        System.out.println("Date: " + date1);

        LocalDate date2 = LocalDate.of(2020, Month.APRIL, 30);
        System.out.println(date2);

        LocalDate date3 = LocalDate.parse("2020/04/30", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("Date From String : " + date3);

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(Period.ofDays(1));
        System.out.println("Today: " + today + " Tomorrow : "+ tomorrow);

        LocalDate date4 = LocalDate.now().plusDays(35);
        System.out.println(date4);

        DayOfWeek dayOfTheWeek = today.getDayOfWeek();
        System.out.println("Day Of  Week : " + dayOfTheWeek.toString().toLowerCase());

        int dayOfMonth = today.getDayOfMonth();
        System.out.println("Day Of Month : " + dayOfMonth);

        System.out.println("Is Before : " + tomorrow.isBefore(today));
        System.out.println("Is Before : " + today.isBefore(tomorrow));
        System.out.println("Is PowerOfTwo leap year : "+today.isLeapYear());

        System.out.println("Start of Today : "+today.atStartOfDay());

        System.out.println("First Day of month" + today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Last Day of month" + today.with(TemporalAdjusters.lastDayOfMonth()));


        System.out.println("<-------- LocalDate Demo End -------->");
    }

    public static void main(String[] args) {
        demoLocalDateTime();
    }
}
