package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PointInInterval {
    public static void main(String[] args) {
        int m = 10, n = 4;
        int[][] intervals = {{-3, 5}, {0,2}, {8, 10}, {6, 7}};
        System.out.println(getMaxPoint(intervals, n, m));

        System.out.println(getMaxPoint(new int[][] {{1,5}, {2,4}, {3,13}, {6, 10},{10,12},{11,13}}, n, m));

        List<int[]> list = getMaxPointRange(new int[][] {{1,5}, {2,4}, {3,13}, {6, 10},{10,12},{11,13}}, n, m);

        list.forEach(i -> System.out.print("["+i[0]+","+i[1]+"] "));
    }

    //TC: O(nlogn +n) ==> O(nlogn)
    //TC: O(n)
    private static int getMaxPoint(int[][] intervals, int n, int m) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        int gloMax = 0;
        int max = 0;
        for(int[] it : intervals) {
            minHeap.offer(new int[] {it[0], 1});
            minHeap.offer(new int[] {it[1], -1});
        }
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            max += cur[1];
            if(max > gloMax) {
                gloMax = max;
            }
        }
        return gloMax;
    }

    //TC: O(nlogn +n) ==> O(nlogn)
    //TC: O(n)
    private static List<int[]> getMaxPointRange(int[][] intervals, int n, int m) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        int gloMax = 0;
        int max = 0;

        List<int[]> res = new ArrayList<>();
        Integer start = null;

        for(int[] it : intervals) {
            minHeap.offer(new int[] {it[0], 1});
            minHeap.offer(new int[] {it[1], -1});
        }
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            max += cur[1];
            if(max > gloMax) {
                gloMax = max;
            }
        }

        for(int[] it : intervals) {
            minHeap.offer(new int[] {it[0], 1});
            minHeap.offer(new int[] {it[1], -1});
        }

        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            max += cur[1];
            if(max == gloMax) {
                start= cur[0];
            } else if(start != null){
                res.add(new int []{start, cur[0]});
                start = null;
            }
        }


        return res;
    }



}
