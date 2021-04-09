package com.dsa.facebook;

import java.util.Stack;

public class Iterate_List_Backwards {


    // Recursive
    //TC: O(n)
    //SC: O(n)
    public void printBackWardsRecursive(ListNode head){
        if(head == null)
            return;

        printBackWardsRecursive(head.next);
        System.out.print(head.val+" ");
    }

    // Iterative
    //TC: O(n)
    //SC: O(n)
    public void printBackWardsIterative(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        if(head == null)
            return;

        ListNode curr = head;
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().val+" ");
        }

    }

    // Iterative
    //TC: O(n^2)
    //SC: O(1)
    public void printBackWardsIterativeNoMemory(ListNode head){
        if(head == null)
            return;

        ListNode last = null;
        while (head != last){
            ListNode curr = head;
            while (curr.next != last){
                curr = curr.next;
            }
            System.out.print(curr.val+" ");
            last = curr;
        }

    }

    // Recursive
    //TC: O(n)
    //SC: O(n)
    public ListNode reverseListRecursive(ListNode head) {
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

    // Iterative
    //TC: O(n)
    //SC: O(n)
    public void reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        while (prev != null){
            System.out.print(prev.val+" ");
            prev = prev.next;
        }
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Iterate_List_Backwards obj = new Iterate_List_Backwards();
        obj.printBackWardsRecursive(n1);
        System.out.println("");
        obj.printBackWardsIterative(n1);
        System.out.println("");
        obj.printBackWardsIterativeNoMemory(n1);
        System.out.println("");
        obj.reverseListIterative(n1);
    }
}
