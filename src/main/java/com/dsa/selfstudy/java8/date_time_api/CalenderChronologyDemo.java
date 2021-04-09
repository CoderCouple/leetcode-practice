package com.dsa.selfstudy.java8.date_time_api;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;

public class CalenderChronologyDemo {

    public static void main(String[] args) {
      chronologyDemo();
    }

    public static void chronologyDemo() {
        Chronology chronology = Chronology.of("islamic");
        ChronoLocalDate islamicDate = chronology.dateNow();
        System.out.println(islamicDate);

        //Date in ISO calender
        LocalDate date = LocalDate.from(islamicDate);
        System.out.println(date);
    }
}
