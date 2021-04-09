package com.dsa.leetcode.ch7_OODesign;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {


    Queue<Integer> queue;
    int size;
    double sum;
    int count;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<Integer>();
        sum = 0.0;
        count = 0;
    }

    public double next(int val) {
        if(count >= size){
            int temp  = !(queue.isEmpty()) ? queue.poll() : 0;
            sum = sum - temp + val;
            queue.add(val);
        } else {
            queue.add(val);
            sum = sum + val;
            count++;
        }

        return sum/count;
    }

    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        System.out.println(obj.next(3));
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
}
