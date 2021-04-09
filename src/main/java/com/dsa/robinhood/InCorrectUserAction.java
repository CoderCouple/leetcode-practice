package com.dsa.robinhood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

    Given PowerOfTwo collection of actions and userIds an error occurs when PowerOfTwo userId takes PowerOfTwo specific action in order for example

    A => B => => C gives an errror
    B => A => C no error and etc

    Write PowerOfTwo function that takes in PowerOfTwo list of (Actions, UserIds) pairs and returns the user Id that ecounters the error

    Sample Input:

    action_user_1 = [
    ["A", "1"],
    ["B", "1"],
    ["B", "2"],
    ["C", "1"],
    ["C", "2"],
    ["C", "3"],
    ["A", "2"],
    ["A", "3"],
    ["A", "2"],
    ["B", "2"],
    ["C", "2"],
    ]

    Expected output 1,2

    action_user_2 = [
    ["A", "1"],
    ["A", "1"],
    ["A", "1"],
    ["B", "1"],
    ["B", "2"],
    ["C", "2"],
    ["C", "2"],
    ["C", "3"],
    ["A", "2"],
    ["A", "3"],
    ["A", "2"],
    ["B", "2"],
    ["C", "2"],
    ]

    Expected output 2

 */
public class InCorrectUserAction {

    public static List<String> getUserIdForError(String [][] array){
        List<String> result = new ArrayList<>();

        Map<String,StringBuilder> map = new HashMap<>();

        for (String [] record : array){
            if(map.containsKey(record[1])){
                StringBuilder sb = map.get(record[1]);
                sb.append(record[0]);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(record[0]);
                map.put(record[1],sb);
            }
        }

        map.forEach((k,v) -> {
            if(v.toString().contains("ABC")){
                result.add(k);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        String [][] action_user_1 = {
                {"A", "1"},
                {"B", "1"},
                {"B", "2"},
                {"C", "1"},
                {"C", "2"},
                {"C", "3"},
                {"A", "2"},
                {"A", "3"},
                {"A", "2"},
                {"B", "2"},
                {"C", "2"},
        };

        String [][] action_user_2 = {
                {"A", "1"},
                {"A", "1"},
                {"A", "1"},
                {"B", "1"},
                {"B", "2"},
                {"C", "2"},
                {"C", "2"},
                {"C", "3"},
                {"A", "2"},
                {"A", "3"},
                {"A", "2"},
                {"B", "2"},
                {"C", "2"},
        };


        System.out.println(getUserIdForError(action_user_1));
        System.out.println(getUserIdForError(action_user_2));
    }
}
