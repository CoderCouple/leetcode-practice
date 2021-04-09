package com.dsa.leetcode.ch2_linked_lists;

import com.dsa.ctci.chapter2.Node;

import java.net.Socket;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(getLength(l1) <= getLength(l2)){
            l1 = addAtHead(l1, getLength(l2)-getLength(l1));
        } else {
            l2 = addAtHead(l2, getLength(l1)-getLength(l2));
        }

        ListNode fakeHead = new ListNode(0);
        int carry = add(l1,l2,fakeHead);
        if(carry == 1){
            fakeHead.val = 1;
            return fakeHead;
        } else {
            return fakeHead.next;
        }

    }

    public int add(ListNode l1, ListNode l2, ListNode head){
        if(l1== null && l2 == null)
            return 0;

        ListNode n1 = l1 == null ? new ListNode(0) : l1;
        ListNode n2 = l2 == null ? new ListNode(0) : l2;

        ListNode n = new ListNode(0);
        int carry = add(n1.next,n2.next,n);
        int sum = carry + n1.val + n2.val;
        int digit = sum % 10;
        carry = sum >= 10 ? 1: 0;
        n.val = digit;
        head.next = n;
        return carry;
    }

    public ListNode addAtHead(ListNode head, int k){
        ListNode currHead = head;
        while(k>0){
            ListNode n = new ListNode(0);
            n.next = currHead;
            currHead = n;
            k--;
        }
        return currHead;
    }

    public int getLength(ListNode head){
        int length = 0;
        if(head == null)
            return length;
        ListNode curr = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        return length;
    }

    public static void main(String[] args) {

        ListNode n7 = new ListNode(5);
        ListNode n1 = new ListNode(2);
        ListNode n6 = new ListNode(7);
        n7.next = n1;
        n1.next = n6;

        ListNode n5 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n5.next = n2;
        n2.next = n3;


        Solution s = new Solution();
        ListNode b = s.addTwoNumbers(n7,n5);
        b.print();
    }
}
