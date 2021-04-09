package com.dsa.leetcode.ch7_OODesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {

    public HashMap<String, RateCounter> clientTimeStampMap = new HashMap<>();

    public boolean isAllow(String clientId) {
        long currTime = System.currentTimeMillis();
        if (!clientTimeStampMap.containsKey(clientId)) {
            RateCounter rc = new RateCounter();
            rc.hit(currTime); return true;
        } else {
            RateCounter rc = clientTimeStampMap.get(clientId);
            return rc.hit(currTime);
        }
    }

    public static void main(String[] args) {
        String clientId = "1234";
        RateLimiter rl = new RateLimiter();
        System.out.println(rl.isAllow(clientId));
    }
}

class RateCounter {
    public int REQUEST_LIMIT = 100;
    public Long TIME_LIMIT = 1000L;
    public Queue<Long> queue;
    public RateCounter() {
        queue = new LinkedList<>();
    }
    public boolean hit(long timestamp) {
        /* when a timestamp hit, we should poll all the timestamp before TIME_LIMIT*/
        while (!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT){
            queue.poll();
        }

        if (queue.size() < REQUEST_LIMIT) {
            queue.add(timestamp); return true;
        }
        return false;
    }
}
