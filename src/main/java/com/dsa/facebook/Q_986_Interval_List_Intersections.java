package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_986_Interval_List_Intersections {

    //TC: O(1)
    //SC: O(1)
    public boolean isOverlapping(Interval first, Interval second){
        return first.end >= second.start && second.end >= first.start;
    }

    //TC: O(1)
    //SC: O(1)
    public Interval getRangeIntersection(Interval first, Interval second){
        return new Interval(Math.max(first.start,second.start),Math.min(first.end,second.end));
    }

    //TC: O(m+n)
    //SC: O(m+n)
    // Linear scan
    public List<Interval> intervalIntersection(List<Interval> firstList, List<Interval> secondList) {
        List<Interval> result = new ArrayList<>();
        //Collections.sort(firstList, Comparator.comparingInt(Interval::getStart));
        //Collections.sort(secondList, Comparator.comparingInt(Interval::getStart));

        int firstIndex =0;
        int secondIndex =0;

        while (firstIndex < firstList.size() && secondIndex < secondList.size()){
            Interval first = firstList.get(firstIndex);
            Interval second = secondList.get(secondIndex);

            if(isOverlapping(first,second)){
                result.add(getRangeIntersection(first,second));
            }

            if(first.end<second.end)
                firstIndex++;
            else secondIndex++;
        }
        return result;
    }

    // Binary Search scan
    public List<Interval> intervalIntersectionBinary(List<Interval> firstList, List<Interval> secondList) {
        List<Interval> result = new ArrayList<>();
        //Collections.sort(firstList, Comparator.comparingInt(Interval::getStart));
        //Collections.sort(secondList, Comparator.comparingInt(Interval::getStart));

        int start =0;
        for(int firstIndex = 0; firstIndex< firstList.size();firstIndex++){
            int res = binarySearch(firstList, start, firstList.get(firstIndex));
            if(res != -1){
                result.add(getRangeIntersection(firstList.get(firstIndex), secondList.get(res)));
                start = res;
            }

        }
        return result;
    }

    // this has bug need to fix it
    public int binarySearch(List<Interval> secondList, int start, final Interval element) {
        int end = secondList.size()-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isOverlapping(secondList.get(mid), element)) {
                return mid;
            } else if (secondList.get(mid).end < element.start) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Q_986_Interval_List_Intersections obj = new Q_986_Interval_List_Intersections();
        System.out.println(obj.intervalIntersection(Arrays.asList(
                new Interval(1,2),
                new Interval(3,4),
                new Interval(7,10)
        ),Arrays.asList(
                new Interval(0,2),
                new Interval(3,8),
                new Interval(9,10)
        ))); // [[1,2],[3,4],[7,8],[9,10]]


        System.out.println(obj.intervalIntersectionBinary(Arrays.asList(
                new Interval(1,2),
                new Interval(3,4),
                new Interval(7,10)
        ),Arrays.asList(
                new Interval(0,2),
                new Interval(3,8),
                new Interval(9,10)
        ))); // [[1,2],[3,4],[7,8],[9,10]]

    }
}
