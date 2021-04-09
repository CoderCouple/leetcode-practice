package com.dsa.facebook;

import java.util.LinkedList;
import java.util.Queue;


//TC: O(1)
//SC: O(k) k = window size
public class Q_346_Moving_Average_From_Data_Stream {
    Queue<Integer> queue;
    int size;
    double sum;
    int count;

    /** Initialize your data structure here. */
    public Q_346_Moving_Average_From_Data_Stream(int size) {
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
}
