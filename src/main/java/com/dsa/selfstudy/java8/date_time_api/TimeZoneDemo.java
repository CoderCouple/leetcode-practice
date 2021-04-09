package com.dsa.selfstudy.java8.date_time_api;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneDemo {

    public static void main(String[] args) {
        timeZoneDemo();
    }

    public static void timeZoneDemo() {


        TimeZone timeZone1 = TimeZone.getDefault();
        System.out.println("TimeZone Default : " + timeZone1);

        System.out.println("TimeZone Name : " + timeZone1.getDisplayName());
        System.out.println("TimeZone ID : " + timeZone1.getID());

        TimeZone timeZone2 = TimeZone.getTimeZone(ZoneOffset.UTC);
        System.out.println("TimeZone UTC : " + timeZone2);

        TimeZone timeZone3 = TimeZone.getTimeZone(ZoneOffset.SHORT_IDS.get("IST"));
        System.out.println("TimeZone IST : " + timeZone3);


        TimeZone timeZoneParis = TimeZone.getTimeZone("Europe/Paris");
        TimeZone timeZoneTokyo = TimeZone.getTimeZone("Asia/Tokyo");

        //Calendar calender = Calendar.getInstance();
        Calendar calender = new GregorianCalendar();
        calender.setTimeZone(timeZoneTokyo);

//        Date date = calender.getTime();
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        System.out.println(format1.format(date));
//        System.out.println(calender.getTime());

        long timeInMillis = calender.getTimeInMillis();
        System.out.println(Instant.ofEpochMilli(timeInMillis).atZone(timeZoneTokyo.toZoneId()).toLocalDateTime());
        System.out.println("Time in Millisec in Tokyo : " + timeInMillis);

        System.out.println("Hour at Tokyo : " + calender.get(Calendar.HOUR));
        System.out.println("Minutes at Tokyo : "  + calender.get(Calendar.MINUTE));

    }
}
