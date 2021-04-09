package com.dsa.leetcode.ch2_linked_lists;

public class Q19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0)
            return head;
        if(head == null)
            return head;
        int len = getLength(head);
        if(len<n)
            return head;

        ListNode ptr = new ListNode(0);
        ptr.next = head;
        ListNode curr = ptr;
        int counter=0;
        while(len-n>counter){
            curr = curr.next;
            counter++;
        }
        curr.next = curr.next.next;
        return ptr.next;
    }


    public int getLength(ListNode head){
        int length = 0;
        ListNode ptr = head;
        while(ptr != null){
            length++;
            ptr = ptr.next;
        }
        return length;
    }

    public static void main(String[] args) {

    }
}
