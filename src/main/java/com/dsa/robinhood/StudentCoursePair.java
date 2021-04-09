package com.dsa.robinhood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
        You are PowerOfTwo developer for PowerOfTwo university. Your current project is to develop PowerOfTwo system for students to find courses they share with friends. The university has PowerOfTwo system for querying courses students are enrolled in, returned as PowerOfTwo list of (ID, course) pairs.

        Write PowerOfTwo function that takes in PowerOfTwo list of (student ID number, course name) pairs and returns, for every pair of students, PowerOfTwo list of all courses they share.

        Sample Input:

        student_course_pairs_1 = [
        ["58", "Linear Algebra"],
        ["94", "Art History"],
        ["94", "Operating Systems"],
        ["17", "Software Design"],
        ["58", "Mechanics"],
        ["58", "Economics"],
        ["17", "Linear Algebra"],
        ["17", "Political Science"],
        ["94", "Economics"],
        ["25", "Economics"],
        ["58", "Software Design"],
        ]

        Sample Output (pseudocode, in any order):

        find_pairs(student_course_pairs_1) =>
        {
        [58, 17]: ["Software Design", "Linear Algebra"]
        [58, 94]: ["Economics"]
        [58, 25]: ["Economics"]
        [94, 25]: ["Economics"]
        [17, 94]: []
        [17, 25]: []
        }

        Additional test cases:

        Sample Input:

        student_course_pairs_2 = [
        ["42", "Software Design"],
        ["0", "Advanced Mechanics"],
        ["9", "Art History"],
        ]

        Sample output:

        find_pairs(student_course_pairs_2) =>
        {
        [0, 42]: []
        [0, 9]: []
        [9, 42]: []
        }

        n: number of pairs in the input
        s: number of students
        c: number of courses being offered

*/
public class StudentCoursePair {


    public static Map<int[], List<String>> getPossiblePairs(String[][] input){
        Map<int[], List<String>> result = new HashMap();
        Map<Integer, Set<String>> adjMap = new HashMap();
        List<Integer> studentIds = new ArrayList();
        for(String[] course : input){
            int studentId = Integer.parseInt(course[0]);
            String studentCourse = course[1];

            if(!adjMap.containsKey(studentId)){
                studentIds.add(studentId);
                Set<String> set = new HashSet<>();
                set.add(studentCourse);
                adjMap.put(studentId,set);
            } else{
                Set<String> set = adjMap.get(studentId);
                set.add(studentCourse);
                adjMap.put(studentId,set);
            }

        }
        for(int i = 0; i < studentIds.size(); i++){
            int curr = studentIds.get(i);
            for(int j = i + 1; j < studentIds.size(); j++){
                List<String> commonCourses = findCommon(studentIds.get(j), curr, adjMap);
                result.put(new int[]{curr, studentIds.get(j)}, commonCourses);
            }
        }
        return result;
    }

    public static List<String> findCommon(int id1, int id2, Map<Integer, Set<String>> adjMap){
        Set<String> student1 = adjMap.get(id1);
        Set<String> student2 = adjMap.get(id2);
        List<String> common = new ArrayList();
        for(String course : student1){
            if(student2.contains(course )){
                common.add(course);
            }
        }
        return common;
    }

    public static void main(String[] args) {

        String [][] student_course_pairs_1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"},
        };


       String[][] student_course_pairs_2 = {
                {"42", "Software Design"},
                {"0", "Advanced Mechanics"},
                {"9", "Art History"},
        };

        Map<int[], List<String>> res1 = getPossiblePairs(student_course_pairs_1);
        res1.forEach((k,v) -> {
            System.out.println("["+k[0]+","+k[1]+"] : "+v);
        });

        System.out.println(" ======================== ");

        Map<int[], List<String>> res2 = getPossiblePairs(student_course_pairs_2);
        res2.forEach((k,v) -> {
            System.out.println("["+k[0]+","+k[1]+"] : "+v);
        });
    }
}
