package com.dsa.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q_13_Roman_To_Integer {

    //TC: O(1)
    //SC: O(1)
    public int romanToInt(String s) {
        Map<String, Integer> romanToInt = new HashMap<>();

        romanToInt.put("I", 1);
        romanToInt.put("V", 5);
        romanToInt.put("X", 10);
        romanToInt.put("L", 50);
        romanToInt.put("C", 100);
        romanToInt.put("D", 500);
        romanToInt.put("M", 1000);

        char c = s.charAt(s.length()-1);
        int result = romanToInt.get(Character.toString(c));

        for(int index = s.length()-2; index >= 0; index--){

            int curr = romanToInt.get(Character.toString(s.charAt(index)));
            int prev = romanToInt.get(Character.toString(s.charAt(index+1)));
            if(curr >= prev){
                result = result + curr;
            } else {
                result = result - curr;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q_13_Roman_To_Integer obj = new Q_13_Roman_To_Integer();
        System.out.println(obj.romanToInt("III"));
        System.out.println(obj.romanToInt("IV"));
        System.out.println(obj.romanToInt("X"));
    }
}
