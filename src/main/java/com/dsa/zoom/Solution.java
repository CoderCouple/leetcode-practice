package com.dsa.zoom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public String rankTeams(String[] votes) {

        Map<Character, int []> map = new HashMap();

        for(String vote: votes){
            for(int rank=0;rank<vote.length();rank++){
                char team = vote.charAt(rank);
                if(!map.containsKey(team)){
                    map.put(team, new int[vote.length()]);
                }
                map.get(team)[rank]++;
            }
        }

        String result =  Arrays.stream(votes[0].split(""))
                .sorted((team1, team2)-> {
                    //System.out.println(team1+": "+team2);
                    for(int i=0;i<votes[0].length();i++){
                        if(map.get(team1.charAt(0))[i]!=map.get(team2.charAt(0))[i])
                            return map.get(team2.charAt(0))[i] - map.get(team1.charAt(0))[i];
                    }
                   return  team1.compareTo(team2);
                })
                .collect(Collectors.joining());

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"}));
        System.out.println(s.rankTeams(new String[]{"WXYZ","XYZW"}));

    }
}