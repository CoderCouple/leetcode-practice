package com.dsa.ctci.chapter2;

import java.util.Stack;

public class Q6_Palindrome {

    public static boolean isPalindromeReverseAndClone(final Node<Integer> head){
        if(head == null)
            return false;

        Node<Integer> curr_head = head;
        Node<Integer> rev_head = reverseAndClone(head);

        while (rev_head != null && curr_head != null){
            if(!rev_head.getData().equals(curr_head.getData()))
                return false;

            rev_head = rev_head.next;
            curr_head = curr_head.next;
        }
        return true;
    }

    public static Node<Integer> reverseAndClone(final Node<Integer> head){
        Node<Integer> curr = head;
        Node<Integer> rev_head = null;

        while (curr != null){
            Node<Integer> n = new Node<>(curr.getData());
            n.next = rev_head;
            rev_head = n;
            curr = curr.next;
        }
        return rev_head;
    }
    public static boolean isPalindromeUsingStack(Node<Integer> head){
        if(head == null)
            return false;

        Stack<Node<Integer>> stack = new Stack<>();
        Node fast = head;
        Node slow = head;
        while(fast !=null && fast.next != null){
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            if(stack.pop().getData() != slow.getData())
                return false;
            slow =slow.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node<Integer> head = Node.getSampleList();

        Node<Integer> n7 = new Node<>(5);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n6 = new Node<>(5);
        n7.next = n1;
        n1.next = n6;

        System.out.println(isPalindromeReverseAndClone(n7));
        System.out.println(isPalindromeUsingStack(n7));
        reverseAndClone(head).print();
    }
}
