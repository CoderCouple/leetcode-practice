package com.dsa.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q_3_Longest_Substring_Without_Repeating_Characters {

    // less Optimized
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        if (s == null || s.isEmpty())
            return max;

        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int index = map.get(c);
                for (int j = start; j <= index; j++) {
                    map.remove(s.charAt(j));
                }
                start = index + 1;
            }

            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    // more optimized version
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        if (s == null || s.isEmpty())
            return max;

        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            max = Math.max(max, i - start + 1);
            map.put(c, i+1);
        }

        return max;
    }

    public static void main(String[] args) {
        String test1 = "abba";
        System.out.println(lengthOfLongestSubstring(test1));
        //evanl@squareup.com
    }
}
