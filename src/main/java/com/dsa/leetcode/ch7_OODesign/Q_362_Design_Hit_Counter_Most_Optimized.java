package com.dsa.leetcode.ch7_OODesign;

public class Q_362_Design_Hit_Counter_Most_Optimized {

    /**
     * Initialize your data structure here.
     */
    int[] timestamp;
    int[] counter;
    int window;
    int count;

    public Q_362_Design_Hit_Counter_Most_Optimized() { // in minutes
        this.window = 5 * 60; // in seconds
        this.timestamp = new int[this.window+1];
        this.counter = new int[this.window+1];
        this.count =0;
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int index = timestamp % this.window;
        if (this.timestamp[index] == timestamp) {
            this.counter[index]++;
        } else {
            this.timestamp[index] = timestamp;
            this.counter[index] = 1;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        count =0;
        for(int index=0; index < this.window; index++){
            if(timestamp-this.timestamp[index]< this.window){
                count+= counter[index];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Q_362_Design_Hit_Counter_Most_Optimized counter = new Q_362_Design_Hit_Counter_Most_Optimized();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));



    }
}
