package com.dsa.facebook;

public class Q_206_Reverse_Linked_List {

    // Recursive
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        reverseListHelper(null,head,newHead);
        return newHead.next;
    }

    public void reverseListHelper(ListNode prev,ListNode curr,ListNode newHead) {
        if(curr == null){
            newHead.next = prev;
            return;
        }
        reverseListHelper(curr,curr.next,newHead);
        curr.next = prev;
    }

    public static void main(String[] args) {

    }
}
