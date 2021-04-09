package com.dsa.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonMusicPairs {
    public static long getSongPairCount(List<Integer> songs) {

        Map<Integer,Integer> frequency = new HashMap<Integer,Integer>();
        for(int songDuration: songs) {
            int modDuration = songDuration % 60;
            //System.out.println("modDuration:"+modDuration);
            frequency.put(modDuration, frequency.getOrDefault(modDuration, 0) + 1);
            //System.out.println("frequency:"+frequency.get(modDuration));
        }

        long pairs = 0;
        for(Map.Entry<Integer,Integer> freqSong: frequency.entrySet()) {
            int search = 60 - freqSong.getKey();
            //System.out.println("Found:"+freqSong.getKey());
            //System.out.println("Searching:"+search);
            if(freqSong.getKey() == 0) {
            }
            else if(freqSong.getKey() == 30) {
                pairs+= freqSong.getValue() - (freqSong.getValue()%2);
            }
            else if(frequency.containsKey(search)) {
                pairs += frequency.get(search) * freqSong.getValue();
            }

            //System.out.println("Adding pairs:"+pairs);

        }
        pairs = pairs/2;


        int nZeroes = frequency.get(0);
        //System.out.println("Number of zeroes" + nZeroes);
        long combinationZeroes = factorial(nZeroes)/(factorial(2)*factorial(nZeroes-2));
        //System.out.println("Combination of zeroes" + factorial(nZeroes)/(factorial(2)*factorial(nZeroes-2)));
        //System.out.println("Combination of zeroes" + combinationZeroes);

        if(pairs == 0 )
            pairs +=combinationZeroes;
        else
            pairs = pairs * combinationZeroes;

        return pairs;
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
