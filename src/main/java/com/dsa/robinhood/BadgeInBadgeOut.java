package com.dsa.robinhood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


    /*
    We want to find which employees aren't using their badge to either enter or exit the building.
    Given PowerOfTwo list of badge records, return two sets - Employees that failed to badge in and another of the employees that failed to badge out.

    We know that at the beginning of the day of badge records, the room is empty and everyone should be gone at the end of the day.

    badge_records = [
      ["Paul" ,  "enter"],
      ["Paul" ,  "enter"],
      ["Curtis" , "enter"],
      ["Paul" , "exit"],
      ["John" , "exit"],
      ["Paul" , "exit"],
      ["Jennifer" , "exit"],
      ["Curtis" , "exit"],
      ["John" , "enter"],
      ["Jennifer" , "enter"],
      ["Curtis" ,  "enter"],
      ["John" , "enter"],
      ["Jennifer" , "enter"],
      ["John" , "exit"],
      ["Curtis" , "exit"],
      ["Jennifer" , "exit"],
    ]

    Failed to Badge In: Paul, John, Jennifer
    Failed to Badge Out: Paul, John, Jennifer

    output:
    Failed to Badge In: [john, paul, jennifer]
    Failed to Badge Out: [paul]

     */

    /* ======================================================================
    We are working on PowerOfTwo security system for PowerOfTwo badged-access room in our company's building.

    We want to find employees who badged into our secured room unusually often.
    We have an unordered list of names and entry times over PowerOfTwo single day.
    Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

    Write PowerOfTwo function that finds anyone who badged into the room three or more times in PowerOfTwo one-hour period.
    Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period.
    If there are multiple one-hour periods where this was true for an employee, just return the first one.

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

/* =========================================================================
    We want to find employees who badged into our secured room together often.
    Given an unordered list of names and access times over PowerOfTwo single day,
    find the largest group of people that were in the room together during two or more separate time periods, and the times when they were all present.

badge_records = [
  ["Paul",     "1214", "enter"],
  ["Paul",      "830", "enter"],
  ["Curtis",   "1100", "enter"],
  ["Paul",      "903", "exit"],
  ["John",      "908", "exit"],
  ["Paul",     "1235", "exit"],
  ["Jennifer",  "900", "exit"],
  ["Curtis",   "1330", "exit"],
  ["John",      "815", "enter"],
  ["Jennifer", "1217", "enter"],
  ["Curtis",    "745", "enter"],
  ["John",     "1230", "enter"],
  ["Jennifer",  "800", "enter"],
  ["John",     "1235", "exit"],
  ["Curtis",    "810", "exit"],
  ["Jennifer", "1240", "exit"],
]

Expected output:
John, Paul, Jennifer: 830 to 900, 1230 to 1235

 */


public class BadgeInBadgeOut {


    /*
        Main idea: we keep PowerOfTwo hashtable {name, [stack of actions]}
        We iterate through the list and we consider the action. If they are entering and the stack is not empty
        and the last value is "enter" as well, then they forgot to exit since you can't enter twice. If they are
        exiting and the stack is empty or the last value in the stack is "enter", then they forgot to enter since
        you cannot exit twice. Follow up question from me: How much time did you get for this question and
        was it the only question in the interview. Could you maybe post the other question too? Runtime is O(n)
        since we go through the array once and array inserting/deleting is O(1). At the end we preform an at
        most linear operation converting the sets to lists so O(n) + O(n) = O(n) Memory is O(n) also, I think.

        class Solution:
            def bad_employees(self, badge_records):
                forgot_enter = set()
                forgot_exit = set()
                stacks = {}
                for name, action in badge_records:
                    if name not in stacks:
                        stacks[name] = []
                    if action == "enter":
                        if stacks[name] and stacks[name][-1] == "enter":
                            forgot_exit.add(name)
                        stacks[name].append(action)
                    else:
                        if stacks[name] == [] or stacks[name][-1] == "exit":
                            forgot_enter.add(name)
                        stacks[name].append(action)
                return [list(forgot_enter), list(forgot_exit)]



        s = Solution()
        badge_records = [
          ["Paul" ,  "enter"],
          ["Paul" ,  "enter"],
          ["Curtis" , "enter"],
          ["Paul" , "exit"],
          ["John" , "exit"],
          ["Paul" , "exit"],
          ["Jennifer" , "exit"],
          ["Curtis" , "exit"],
          ["John" , "enter"],
          ["Jennifer" , "enter"],
          ["Curtis" ,  "enter"],
          ["John" , "enter"],
          ["Jennifer" , "enter"],
          ["John" , "exit"],
          ["Curtis" , "exit"],
          ["Jennifer" , "exit"],
        ]
        lst = s.bad_employees(badge_records)
        assert "John" in lst[0]
        assert "Paul" in lst[1] and "Paul" in lst[0]
        assert "Jennifer" in lst[0]
        print("Success!")
     */


    //https://leetcode.com/discuss/interview-question/911433/Robinhood-New-Grad-Karat
    public static void problem1(String[][] badge_records){
        if(badge_records == null || badge_records.length == 0 )
            return;

        List<String> failedToBadgeIn = new ArrayList<>();
        List<String> failedToBadgeOut = new ArrayList<>();

        Set<String> room = new HashSet<String>();

        for(String [] record : badge_records){
            String name = record[0];
            String status = record[1];

            if(room.contains(name)){
                if(status.equalsIgnoreCase("enter")){
                    failedToBadgeOut.add(name);
                } else {
                    room.remove(name);
                }
            } else {
                if(status.equalsIgnoreCase("enter")){
                    room.add(name);
                } else {
                    failedToBadgeIn.add(name);
                }
            }
        }

        room.stream().forEach(name -> failedToBadgeOut.add(name));
        System.out.println(failedToBadgeIn);
        System.out.println(failedToBadgeOut);
    }

    static Map<String, List<String>> problem2(String[][] badge_times) {
        /*
            Name with start time as Key - All the times as list of values
            Find those that have size more than 3
            Split character and num and insert it as key and insert those that have size more than 3 as values
            return the map

            T - O(n + n)
            S - O(n)
        */

        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < badge_times.length; i++) {
            String[] entry = badge_times[i];
            String num = "";
            if(entry[1].length() > 3) {
                num = entry[1].substring(0, 2);
            } else {
                num = entry[1].substring(0,1);
            }
            String key = entry[0] +  num;

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(entry[1]);
            map.put(key, list);
        }

        Map<String, List<String>> resultMap = new HashMap<>();

        for(String str: map.keySet()) {
            if(map.get(str).size() >= 3) {
                String k = str.split("[0-9]")[0];
                // In order to get the first entry replace the old entry with the newer ones as the map is reverse sorted
                List<String> l = new ArrayList<>();
                l.addAll(map.get(str));
                resultMap.put(k, l);
            }
        }
        return resultMap;
    }

    // John, Paul, Jennifer: 830 to 900, 1230 to 1235
    public static void problem3(final String[][] badge_records3) {
        Arrays.sort(badge_records3, Comparator.comparing((k1) -> Integer.valueOf(k1[1])));
        System.out.println(Arrays.deepToString(badge_records3));

        Map<String, Integer> entryMap = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();


        for(String [] record : badge_records3){
            String name = record[0];
            Integer time = Integer.valueOf(record[1]);
            String state = record[2];

            if("enter".equalsIgnoreCase(state)){
                entryMap.put(name,time);
            } else {
                int max = Integer.MIN_VALUE;
               StringBuilder key = new StringBuilder();
               for (Map.Entry<String, Integer> entry: entryMap.entrySet()){
                   key.append(entry.getKey()).append(":");
                   max = Math.max(max,entry.getValue());
               }
               List<String> l = map.getOrDefault(key.toString(),new ArrayList<>());
               l.add(max+" to "+time);
               String [] names = key.toString().split(":");
               Arrays.sort(names);

               map.put(key.toString(),l);
               entryMap.remove(name);
            }
        }

        map.forEach((k,v) -> {
            if (v.size()>=2)
                System.out.println(k+" "+v);
        });

    }


    public static void main(String[] args) {
        String [][]  badge_records1 = {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"John", "exit"},
                {"Paul", "exit"},
                {"Jennifer", "exit"},
                {"Curtis", "exit"},
                {"John", "enter"},
                {"Jennifer", "enter"},
                {"Curtis", "enter"},
                {"John", "enter"},
                {"Jennifer", "enter"},
                {"John", "exit"},
                {"Curtis", "exit"},
                {"Jennifer", "exit"},
        };

        String [][]  badge_records2 = {
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
                {"Jennifer",    "5"}
        };

        String [][]  badge_records3 = {
                {"Paul",     "1214", "enter"},
                {"Paul",      "830", "enter"},
                {"Curtis",   "1100", "enter"},
                {"Paul",      "903", "exit"},
                {"John",      "908", "exit"},
                {"Paul",     "1235", "exit"},
                {"Jennifer",  "900", "exit"},
                {"Curtis",   "1330", "exit"},
                {"John",      "815", "enter"},
                {"Jennifer", "1217", "enter"},
                {"Curtis",    "745", "enter"},
                {"John",     "1230", "enter"},
                {"Jennifer",  "800", "enter"},
                {"John",     "1235", "exit"},
                {"Curtis",    "810", "exit"},
                {"Jennifer", "1240", "exit"},
        };


       // problem1(badge_records1);
//        Map<String, List<String>> map =  problem2(badge_records2);
//        map.forEach((k,v) -> {
//            System.out.println(k+" : "+v);
//        });
        // problem3(badge_records3);
//        System.out.println("Sunil".substring(2)); //nil
//        System.out.println("Sunil".substring(2,3)); //n
    }

}
