package com.dsa.selfstudy.java8.date_time_api;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class PeriodDurationDemo {

    public static void instantDemo() {


        // -------------------------  Instant ----------------------------
        Instant instant = Instant.now();
        System.out.println("Instant  : " + instant);

        System.out.println("Plus One Day : " + instant.plus(1, ChronoUnit.DAYS));
        System.out.println("Plus One Day : " + instant.plus(Period.ofDays(1)));

        System.out.println("Plus Two Day : " + instant.plus(2, ChronoUnit.DAYS));
        System.out.println("Plus Two Day : " + instant.plus(Period.ofDays(2)));

        System.out.println("Plus One Hour : " + instant.plus(1, ChronoUnit.HOURS));
        System.out.println("Plus One Hour : " + instant.plus(Duration.ofHours(1)));

        System.out.println("Plus Two Hour : " + instant.plus(2, ChronoUnit.HOURS));
        System.out.println("Plus Two Hour : " + instant.plus(Duration.ofHours(2)));
        // Duration = Time based units
        // Periods = Date base units

        LocalDateTime dt1 = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        System.out.println("LocalDateTime from Instant : " + dt1);

    }


    public static void durationDemo() {
        //-------------------------- Duration -------------------------------

        Duration d1 = Duration.ofHours(1);
        System.out.println("Duration of One Hour : " + d1);
        System.out.println("Duration of One Hour : " + d1.getSeconds());

        Duration d2 = Duration.of(1, ChronoUnit.HOURS);
        System.out.println("Duration of One Hour : " + d2);
        System.out.println("Duration of One Hour : " + d2.getSeconds());

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        System.out.println("Today : " + today);
        System.out.println("Tomorrow : " + tomorrow);
        System.out.println("Duration between 2 dates : " + Duration.between(today, tomorrow).toHours() + "hrs");


        System.out.println("Duration from String : " + Duration.parse("P1DT5H30M5S").toNanos());

    }

    public static void periodDemo() {
        //--------------------------- Period --------------------------------

        LocalDate dt4 = LocalDate.now();
        LocalDate dt5 = LocalDate.now().plus(35, ChronoUnit.DAYS);
        System.out.println("Period : " + Period.between(dt4, dt5));

        Period p = Period.of(3,10,2);
        System.out.println("Years of Period : " + p.getYears());
        System.out.println("Month of Period : " + p.getMonths());
        System.out.println("Days of Period : " + p.getDays());

        Period p3 = Period.ofYears(2);
        printPeriod(p3);

        Period p4 = Period.ofMonths(3);
        printPeriod(p4);

        Period p2 = Period.ofDays(5);
        printPeriod(p2);

        Period p5 = Period.parse("P2Y3M5D");
        printPeriod(p5);

    }

    public static void printPeriod(Period period){
        System.out.println("Year : " + period.getYears() + " Month : " + period.getMonths() + " Days : " + period.getDays());
    }

    public static void main(String[] args) {
        instantDemo();
        durationDemo();
        periodDemo();
    }
}
