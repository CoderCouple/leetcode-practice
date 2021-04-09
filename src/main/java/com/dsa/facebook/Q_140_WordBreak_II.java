package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q_140_WordBreak_II {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        List<String> result = new ArrayList<>();
        Map<Integer,String> dp = new HashMap<>();

        wordBreakHelper(s,0,set, new StringBuilder(),result,dp);
        //result.sort(Comparator.naturalOrder());
        return result;
    }

    public static void  wordBreakHelper(String s, int index, Set<String> wordDict, StringBuilder curr, List<String> result,Map<Integer,String> dp ){
        if(index>=s.length())
            return;

        if(wordDict.contains(s.substring(index))){
            if(curr.length() !=0 ){
                curr.append(" ");
            }
            curr.append(s.substring(index));
            result.add(curr.toString());
            return;
        }

        if(dp.containsKey(s)){
            result.add(dp.get(s));
            return;
        }

        for(int i = index; i<s.length(); i++){
            String word = s.substring(index,i);
            if(wordDict.contains(word)){
                if(curr.length() !=0 ){
                    curr.append(" ");
                }
                curr.append(word);
                int start = curr.length();
                wordBreakHelper(s,i,wordDict,curr,result,dp);
                curr.delete(start,curr.length());
            }
        }

    }


    public static void main(String[] args) {
        String s1 = "pineapplepenapple";
        List<String> wordDict1 = Arrays.asList("apple","pen","applepen","pine","pineapple");
        System.out.println(wordBreak(s1,wordDict1));

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s2,wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s3,wordDict3));

    }
}