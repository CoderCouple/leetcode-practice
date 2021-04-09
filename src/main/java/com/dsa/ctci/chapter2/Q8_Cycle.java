package com.dsa.ctci.chapter2;

public class Q8_Cycle {

    public static Node<Integer> findTheBeginningOfTheCycle(Node<Integer> head){
        if(head == null)
            return head;

        //find collision point
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }

        // Checking for the case if there is no loop
        if(fast == null || fast.next == null)
            return null;

        // finding the start of the loop
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
    public static void main(String[] args) {

        Node<Integer> n7 = new Node<>(5);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n9 = new Node<>(9);
        Node<Integer> n3 = new Node<>(3);

        n7.next = n1;
        n1.next = n6;
        n6.next = n9;
        n9.next = n3;
        n3.next = n6;

        System.out.println(findTheBeginningOfTheCycle(n7));
    }
}
