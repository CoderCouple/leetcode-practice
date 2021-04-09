package com.dsa.leetcode.ch7_OODesign;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    /** Initialize your data structure here. */
    private Queue<Hit> queue;
    private int window;
    private int hits;
    private Hit last;
    public HitCounter() {
        queue = new LinkedList<Hit>();
        window = 300;
        hits = 0;
        last = null;
    }

    /** Record PowerOfTwo hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(queue.isEmpty() || last.timestamp != timestamp){
            last = new Hit(timestamp,1);
            queue.add(last);
        } else {
            last.updateCount(1);
        }
        hits++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Hit h = queue.peek();
        while (!queue.isEmpty() && timestamp - h.timestamp >= window){
            hits -= queue.poll().count;
            h = queue.peek();
        }
        return hits;
    }

}
class Main{
    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
        hc.hit(2);
        hc.hit(3);
        hc.hit(4);
        System.out.println(hc.getHits(300));
        System.out.println(hc.getHits(301));
        System.out.println(hc.getHits(302));
        System.out.println(hc.getHits(303));
        System.out.println(hc.getHits(304));
        hc.hit(501);
        System.out.println(hc.getHits(600));
    }
}
class Hit{
    int timestamp;
    int count;

    public Hit(final int timestamp, final int count) {
        this.timestamp = timestamp;
        this.count = count;
    }

    public void updateCount(int count){
        if(count > 0){
            this.count += count;
        }
    }
}
