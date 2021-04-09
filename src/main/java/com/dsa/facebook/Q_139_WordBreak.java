package com.dsa.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q_139_WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        Map<Integer,Boolean> dp = new HashMap<>();
        return wordBreakHelper(s,0,set,dp);
    }

    public static boolean wordBreakHelper(String s, int index, Set<String> wordDict, Map<Integer,Boolean> dp){
        if(index>=s.length())
            return false;

        if(wordDict.contains(s.substring(index))){
            dp.put(index,true);
            return true;
        }

        if(dp.containsKey(index))
            return dp.get(index);

        boolean result = false;
        for(int i = index; i<s.length(); i++){
            String word = s.substring(index,i);
            if(wordDict.contains(word)){
                boolean curr = wordBreakHelper(s,i,wordDict,dp);
                dp.put(i,curr);
                result = result || curr;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s1,wordDict1));

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s2,wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s3,wordDict3));

    }
}