package com.dsa.robinhood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    I got the similar question to " 210 Course Schedule II" on Karat.io platform.

    Instead of the integer 2D array of [course,prerequisite] form and the number of courses, the input was ONLY 2D String array of [prerequisite,course] form.
    Notice the inversion of the mapping form then the original question.

    The output was supposed to be the name of the course which will be currently taken if you are at the halfway stage.

    Example input:
    [DS Algo]
    [FoundationCS OS]
    [CN CA]
    [Algo FundationCS]
    [CA DS]
    [SD CN]

    Output: DS

    Explaination: Total 7 courses are there. if you look at the mapping and list out the order of courses. DS will be the 4th course. so at HALFWAY, you are taking DS.

    If there are 6 courses, Then return the 3rd course of the sequence, not 4th bacause at Halfway, what course you are doing (or just finished) is course number 3.

 */

public class CourseSchedule {

    public static String midWayCourse(String[][] courses){
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < courses.length; i++) {

            String course = courses[i][1];
            String prereq = courses[i][0];

            if (map.containsKey(course)) {
                List<String> list = map.get(course);
                list.add(prereq);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(prereq);
                map.put(course, list);
            }

            map.putIfAbsent(prereq, new ArrayList<String>());

        }

        Set<String> visited = new HashSet<>();
        String[] allCourses = map.keySet().toArray(new String[map.keySet().size()]);
        List<String> results = new ArrayList<>();

        for (String course : allCourses) {
            dfs(course, results, visited, map);
        }

        System.out.println(Arrays.toString(results.toArray()));

        int halfway = (int) Math.floor(results.size() / 2);

        return results.get(halfway);
    }

    public static void dfs(String node, List<String> results, Set<String> visited, Map<String, List<String>> map) {

        if (visited.contains(node)) return;

        visited.add(node);
        List<String> prereqs = map.get(node);

        for (String course : prereqs) {
            dfs(course, results, visited, map);
        }

        results.add(node);

    }
    public static void main(String[] args) {
        //Prerequisite, Course pairs
        String[][] input = {
                {"Data Science", "Algorithms"},
                {"Foundation CS", "Operating Systems"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundation CS"},
                {"Computer Architecture", "Data Science"},
                {"Starting Day", "Computer Networks"},
        };

        System.out.println("Answer: " + midWayCourse(input));

    }
}
