package com.dsa.leetcode.ch2_linked_lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
            return null;

        ListNode fakeNoode = new ListNode(0);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        Arrays.stream(lists).filter(x -> x !=null).forEach(x -> minHeap.add(x));

        ListNode ptr = fakeNoode;
        while (!minHeap.isEmpty()){
            ListNode head = minHeap.poll();
            ptr.next = head;
            head = head.next;
            ptr = ptr.next;
            if(head != null)
                minHeap.add(head);
        }

        return fakeNoode.next;
    }

    public static void main(String[] args) {

    }
}


