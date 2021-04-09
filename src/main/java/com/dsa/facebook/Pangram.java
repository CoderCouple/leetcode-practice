package com.dsa.facebook;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pangram {

    //TC: O(m * n) but since m = 26  => O(26 * n) hence O(n)
    //SC: O(m)
    // n: number of characters in the given string (sentence)
    // m: number of unique characters in the pattern (word) which is 26

    public String getPangramString(String sentence, String word){
        String result = "";
        Pair<Integer,Integer> res = Pair.of(null,null);
        if(sentence == null || sentence.isEmpty())
            return result;

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(char c: word.toCharArray()){
            map.put(c,null);
        }

        int runningMin = 0;
        int length = word.length();
        String curr = "";
        for(int index=0; index<sentence.length();index++){
            char c = sentence.charAt(index);
            if(map.containsKey(c)) {
                if(map.get(c) == null)
                    length--;

                map.put(c, index);
                if(length ==0) {
                    runningMin = getMin( new ArrayList<Integer>(map.values()));
                    curr = sentence.substring(runningMin,index+1);

                    // Reset counter and hashmap
                    length = word.length();
                    map = new HashMap<>();
                    for(char ch: word.toCharArray()){
                        map.put(ch,null);
                    }

                    Pair<Integer,Integer> currPair = Pair.of(runningMin,index);
                    if(res.getLeft() == null && res.getRight()==null){
                        res = currPair;
                        result = curr;
                    } else {
                       res = res.getRight() - res.getLeft() < currPair.getRight() - currPair.getLeft() ? res : currPair;
                       result =  result.length() < curr.length() ? result : curr;
                    }
                }
            }

        }
        // return res    if they want indexes
        return result;
    }

    public int getMin(List<Integer> list){
        int min = Integer.MAX_VALUE;
        for(int num: list){
            if(num < min)
                min = num;
        }
        return min;
    }


    public static void main(String[] args) {
        Pangram obj = new Pangram();
        System.out.println(obj.getPangramString("aaccbc","abc"));
        System.out.println(obj.getPangramString("aaccbcabc","abc"));
    }
}
