package com.dsa.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumNumberOfMeetingRooms {


    //TC: O(1)
    //SC: O(1)
    public boolean isOverlapping(Interval first, Interval second){
        return first.end >= second.start && second.end >= first.start;
    }


    //TC: O(1)
    //SC: O(1)
    public Interval mergeRange(Interval first, Interval second){
        return new Interval(Math.min(first.start,second.start),Math.max(first.end,second.end));
    }


    //TC: O(nlogn)
    //SC: O(n)
    public int minMeetingRooms(List<Interval> intervals) {
        int result =0;
        if(intervals == null || intervals.size() == 0)
            return result;

        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.size(), Comparator.comparingInt(Interval::getEnd));
        Collections.sort(intervals, Comparator.comparingInt(Interval::getStart));

        for(Interval i : intervals){
            if (minHeap.isEmpty() || isOverlapping(minHeap.peek(), i)) {
                minHeap.add(i);
            } else {
                minHeap.poll();
                minHeap.add(i);
            }

            result = Math.max(minHeap.size(), result);
        }
        return result;
    }

    //TC: O(nlogn)
    //SC: O(n)
    public void printBusytTime(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(Interval::getStart));
        LinkedList<Interval> result = new LinkedList<>();
        for(Interval i : intervals){
            if(result.isEmpty() || !isOverlapping(i,result.getLast())){
                result.add(i);
            } else{
                Interval mergedInterval = mergeRange(i,result.getLast());
                result.removeLast();
                result.addLast(mergedInterval);
            }
        }

        result.forEach(System.out::print);
    }

    public static void main(String[] args) {
        MinimumNumberOfMeetingRooms obj = new MinimumNumberOfMeetingRooms();
        System.out.println(obj.minMeetingRooms(Arrays.asList(new Interval(0,30), new Interval(5,10), new Interval(15,20))));
        System.out.println(obj.minMeetingRooms(Arrays.asList(new Interval(7,10), new Interval(2,4))));

        obj.printBusytTime(Arrays.asList(new Interval(0,30), new Interval(5,10), new Interval(15,20)));
        System.out.println("");
        obj.printBusytTime(Arrays.asList(new Interval(7,10), new Interval(2,4)));
    }
}
