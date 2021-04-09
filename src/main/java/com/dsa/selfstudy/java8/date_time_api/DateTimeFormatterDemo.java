package com.dsa.selfstudy.java8.date_time_api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        dateTimeFormatterDemo();
    }

    public static void dateTimeFormatterDemo() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Basic ISO Format : " + localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("ISO Date Format : " + localDate.format(DateTimeFormatter.ISO_DATE));


        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("ISO Date Time Format : " + dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("ISO Time Format : " + dateTime.format(DateTimeFormatter.ISO_TIME));
        System.out.println("ISO WEEK DATE Format : " + dateTime.format(DateTimeFormatter.ISO_WEEK_DATE));


        System.out.println("ISO FormatStyle.FULL : " + dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println("ISO FormatStyle.LONG : " + dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println("ISO FormatStyle.SHORT : " + dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println("ISO FormatStyle.MEDIUM : " + dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));


        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ISO FormatStyle.FULL : " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println("ISO FormatStyle.LONG : " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println("ISO FormatStyle.SHORT : " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        System.out.println("ISO FormatStyle.MEDIUM : " + zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
        System.out.println(localDate.format(df1));
    }
}
