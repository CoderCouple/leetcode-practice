package com.dsa.robinhood;

/*
We are working on PowerOfTwo security system for PowerOfTwo badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over PowerOfTwo single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write PowerOfTwo function that finds anyone who badged into the room three or more times in PowerOfTwo one-hour period. Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = [
  ["Paul",     "1355"],
  ["Jennifer", "1910"],
  ["John",      "835"],
  ["John",      "830"],
  ["Paul",     "1315"],
  ["John",     "1615"],
  ["John",     "1640"],
  ["Paul",     "1405"],
  ["John",      "855"],
  ["John",      "930"],
  ["John",      "915"],
  ["John",      "730"],
  ["John",      "940"],
  ["Jennifer", "1335"],
  ["Jennifer",  "730"],
  ["John",     "1630"],
  ["Jennifer",    "5"]
]

Expected output (in any order)
  John:  830  835  855  915  930
  Paul: 1315 1355 1405

n: length of the badge records array
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void getUsers(String[][] badgeTimes){
        Arrays.sort(badgeTimes,Comparator.comparing(k -> Integer.valueOf(k[1])));
        Map<String,List<String>> map = new HashMap<>();

        for(String [] record: badgeTimes){
            String name = record[0];
            String time = record[1];
            if(map.containsKey(name)){
                List<String> list = map.get(name);
                list.add(time);
            } else{
                List<String> list = new ArrayList<>();
                list.add(time);
                map.put(name,list);
            }
        }


        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            int counter =0;

            String key = entry.getKey();
            List<String> list = entry.getValue();
            int start = getTimeInMinutes(list.get(0));
            for(int i=1; i<list.size(); i++){
                List<String> res = new ArrayList<>();
                int time = getTimeInMinutes(list.get(i));
                res.add(list.get(0));
                if(time-start <= 60){
                    counter++;
                    res.add(list.get(i));
                    if(counter>=3){
                        System.out.println(key+":"+res);
                        break;
                    }

                } else{
                    start = time;
                    counter =0;
                    res = new ArrayList<>();
                }
            }

        }

    }

    public static Integer getTimeInMinutes(String time){
        String minutes = time.substring(Math.max(time.length()-2,0));
        String hours = time.substring(0,Math.max(time.length()-2,0));
        int hrs =0;
        int mins =0;
        if(hours != "")
            hrs = Integer.valueOf(hours);

        if(minutes != "")
            mins = Integer.valueOf(minutes);
        Integer m = hrs*60+mins;
        return m;
    }

    public static void main(String[] argv) {
        String[][] badgeTimes = new String[][] {
                {"Paul",     "1355"},
                {"Jennifer", "1910"},
                {"John",      "835"},
                {"John",      "830"},
                {"Paul",     "1315"},
                {"John",     "1615"},
                {"John",     "1640"},
                {"Paul",     "1405"},
                {"John",      "855"},
                {"John",      "930"},
                {"John",      "915"},
                {"John",      "730"},
                {"John",      "940"},
                {"Jennifer", "1335"},
                {"Jennifer",  "730"},
                {"John",     "1630"},
                {"Jennifer",    "5"},
        };

        getUsers(badgeTimes);

    }
}

