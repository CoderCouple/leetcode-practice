package com.dsa.leetcode.ch2_linked_lists;

public class Q2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        int carry =0;
        ListNode head = new ListNode(0);
        ListNode ptr = head;

        while(l1 != null || l2 != null){
            ListNode num1 = l1 == null ? new ListNode(0): l1;
            ListNode num2 = l2 == null ? new ListNode(0): l2;

            int sum = num1.val + num2.val + carry;
            int digit = sum % 10;
            carry = sum >= 10 ? 1: 0;
            ptr.next = new ListNode(digit);

            ptr = ptr.next;
            l1 = num1.next;
            l2 = num2.next;

        }

        if(carry == 1)
            ptr.next = new ListNode(carry);

        return head.next;

    }

    public static void main(String[] args) {

    }
}


