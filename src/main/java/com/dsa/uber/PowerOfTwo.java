package com.dsa.uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PowerOfTwo {
    public static int pairSummingToPowerOfTwo(int[] a) {
        int max = a[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Integer f = map.get(a[i]);
            if (f == null) f = 0;

            map.put(a[i], f+1);

            if (a[i] > max) max = a[i];
        }

        int numPairs = 0;

        Set<Integer> allTwos = getAllTwos(max * 2);

        for (int key : map.keySet()) {
            numPairs += getNumPairs(key, map, allTwos);
        }

        numPairs /= 2;

        for (int i = 0; i < a.length; i++) {
            if (allTwos.contains(a[i] * 2)) numPairs ++;
        }

        return numPairs;
    }

    private static int getNumPairs(int key, Map<Integer, Integer> freqs, Set<Integer> twos) {
        int numPairs = 0;
        for (int two : twos) {
            Integer complimentF = freqs.get(two - key);
            if (complimentF != null && key * 2 != two) numPairs += complimentF * freqs.get(key);
            if (complimentF != null && key * 2 == two) numPairs += complimentF * (complimentF - 1);
        }
        return numPairs;
    }

    private static Set<Integer> getAllTwos(int max) {
        Set<Integer> twos = new HashSet<>();
        int num = 1;

        while (max >= num && num > 0) {
            twos.add(num);
            num = num << 1;
        }

        return twos;
    }
}
