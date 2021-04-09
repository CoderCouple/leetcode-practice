package com.dsa.leetcode.ch5_sorting_searching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {return Integer.compare(o1[0],o2[0]);});
        LinkedList <int[]> result = new LinkedList<>();

        if(intervals.length <= 1)
            return intervals;
        int [] curr = intervals[0];
        for(int [] interval : intervals){
            if(interval[0]<=curr[1]){
                curr[0] = Math.min(curr[0],interval[0]);
                curr[1] = Math.min(curr[1],interval[1]);
            } else{
                result.add(curr);
                curr = interval;
            }
        }

        if(result.getLast()[1] != curr[1]){
            result.add(curr);
        }

        return (int[][]) result.toArray();
    }
    public static void main(String[] args) {

    }
}
