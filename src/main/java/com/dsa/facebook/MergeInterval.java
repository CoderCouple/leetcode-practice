package com.dsa.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

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
    public List<Interval> sortAndMerge(List<Interval> intervals){
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
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
        return  result;
    }

    // Assuming that the interval list is already sorted
    //TC: O(n)
    //SC: O(n)
    public List<Interval> addAndMerge(List<Interval> intervals,Interval interval){
        //Collections.sort(intervals,Comparator.comparingInt(Interval::getStart));
        LinkedList<Interval> result = new LinkedList<>();
        int  index =0;

        while (index < intervals.size() && !isOverlapping(intervals.get(index), interval)){
            result.add(intervals.get(index));
            index++;
        }

        result.add(interval);

        while (index<intervals.size()){
            if(result.isEmpty() || !isOverlapping(intervals.get(index),result.getLast())){
                result.add(intervals.get(index));
            } else{
                Interval mergedInterval = mergeRange(intervals.get(index),result.getLast());
                result.removeLast();
                result.addLast(mergedInterval);
            }
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        MergeInterval obj = new MergeInterval();


        System.out.println("====================================");
        System.out.println(obj.isOverlapping(new Interval(1,3), new Interval(3,5))); // true
        System.out.println(obj.isOverlapping(new Interval(1,3), new Interval(4,5))); // false
        System.out.println(obj.isOverlapping(new Interval(4,5), new Interval(1,3))); // false
        System.out.println(obj.isOverlapping(new Interval(1,3), new Interval(2,4))); // true
        System.out.println(obj.isOverlapping(new Interval(2,4), new Interval(1,3))); // true
        System.out.println(obj.isOverlapping(new Interval(1,5), new Interval(2,4))); // true
        System.out.println(obj.isOverlapping(new Interval(2,4), new Interval(1,5))); // true

        System.out.println("====================================");
        System.out.println(obj.mergeRange(new Interval(1,3), new Interval(3,5))); // Interval{start=1, end=5}
        System.out.println(obj.mergeRange(new Interval(1,3), new Interval(2,4))); // Interval{start=1, end=4}
        System.out.println(obj.mergeRange(new Interval(2,4), new Interval(1,3))); // Interval{start=1, end=4}
        System.out.println(obj.mergeRange(new Interval(1,5), new Interval(2,4))); // Interval{start=1, end=5}
        System.out.println(obj.mergeRange(new Interval(2,4), new Interval(1,5))); // Interval{start=1, end=5}


        System.out.println("====================================");
        System.out.println(obj.sortAndMerge(Arrays.asList(
                new Interval(1,3),
                new Interval(2,6),
                new Interval(8,10),
                new Interval(15,18)
        ))); // [[1,6],[8,10],[15,18]]

        System.out.println(obj.sortAndMerge(Arrays.asList(
                new Interval(1,4),
                new Interval(4,5)
        ))); //  [[1,5]]



        System.out.println("====================================");
        System.out.println(obj.addAndMerge(Arrays.asList(
                new Interval(1,3),
                new Interval(6,9)
        ), new Interval(2,5))); //  [[1,5], [6,9]]

        System.out.println(obj.addAndMerge(Arrays.asList(
                new Interval(1,2),
                new Interval(3,5),
                new Interval(6,7),
                new Interval(8,10),
                new Interval(12,16)
        ), new Interval(4,8))); //  [[1,2],[3,10],[12,16]]

        System.out.println(obj.addAndMerge(Arrays.asList(), new Interval(5,7))); //  [[5,7]]

        System.out.println(obj.addAndMerge(Arrays.asList(new Interval(1,5)),new Interval(2,3))); //  [[1,5]]

        System.out.println(obj.addAndMerge(Arrays.asList(new Interval(1,5)), new Interval(2,7))); //  [[1,7]]
    }
}

class Interval{
    public int start;
    public int end;

    public Interval(){}

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append(start);
        sb.append(",").append(end);
        sb.append(']');
        return sb.toString();
    }
}
