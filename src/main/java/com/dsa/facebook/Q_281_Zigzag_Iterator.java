package com.dsa.facebook;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TC:
// hasNext() : O(1)
// next(): O(1)

//SC: O(1)
public class Q_281_Zigzag_Iterator {

    Queue<Iterator<Integer>> q;

    public Q_281_Zigzag_Iterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if (!v1.isEmpty()) q.offer(v1.iterator());
        if (!v2.isEmpty()) q.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> cur = q.poll();
        int res = cur.next();
        if (cur.hasNext()) q.offer(cur);
        return res;
    }

    public boolean hasNext() {
        return q.peek() != null;
    }
}
