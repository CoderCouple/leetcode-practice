package com.dsa.facebook;

import java.util.HashMap;

class Pair {
    int left;
    int right;

    Pair(int l, int r) {
        left = l;
        right = r;
    }

    int getLeft() {
        return left;
    }

    int getRight() {
        return right;
    }
}

public class Q_1027_Longest_Arithmetic_Subsequence {

    //TC: O(n^2)
    //SC: O(n)
    public int longestArithSeqLength2(int[] A) {
        if(A.length < 2)
            return A.length;

        HashMap<Integer, Pair> num_to_len_and_diff = new HashMap<>();
        int max = 2;
        for(int i = 0; i < A.length; i++) {
            int first = A[i];
            for(int j = i+1; j< A.length; j++) {
                int second = A[j];
                int len = 2;
                int diff = second - first;
                if(num_to_len_and_diff.containsKey(second)) {
                    Pair len_and_diff = num_to_len_and_diff.get(second);
                    len = len_and_diff.getLeft() + 1;
                    diff = len_and_diff.getRight();
                    if(len > max)
                        max = len;
                    //System.out.println("Pair: "+len_and_diff.getLeft()+", "+ len_and_diff.getRight());
                    num_to_len_and_diff.remove(second);

                }
                num_to_len_and_diff.put(second + diff,new Pair(len, diff));

            }
        }
        return  max;
    }


    //TC: O(n^2)
    //SC: O(n^2)
    // Write this approach

    //Example :  3,6,9,12
    // [ [:], [3:1], [6:1,3:2], [9:1,6:1, 3:3] ]

    public int longestArithSeqLength(int[] A) {
        int length = A.length;
        HashMap<Integer, Integer>[] arrayOfMap = new HashMap[length];
        int maxValue =1;

        for(int f=0; f<length; f++){
            int currElement = A[f];

            //Empty HashMap that we are going to fill.
            arrayOfMap[f] = new HashMap<>();
            HashMap<Integer, Integer> currMap = arrayOfMap[f];

            for(int s=0; s<f; s++){
                int diff = currElement - A[s];
                HashMap<Integer,Integer> prevMap = arrayOfMap[s];
                int newVal =  prevMap.getOrDefault(diff,0)+1;
                currMap.put(diff,newVal);
                arrayOfMap[f] = currMap;
                maxValue = Math.max(maxValue,currMap.get(diff));
            }
        }
        return maxValue+1;
    }

}
