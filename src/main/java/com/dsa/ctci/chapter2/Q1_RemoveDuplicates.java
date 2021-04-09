package com.dsa.ctci.chapter2;

import java.util.HashSet;
import java.util.Set;

public class Q1_RemoveDuplicates {

    public static Node<Integer> removeDuplicates(final Node<Integer> head){
        Set<Integer> table = new HashSet<>();

        Node<Integer> prev = null;
        Node<Integer> curr = head;
        while (curr.next != null){
            if(table.contains(curr.data)){
                prev.next = curr.next;
                curr = curr.next;
            } else {
                table.add(curr.getData());
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static Node<Integer> removeDuplicates2(final Node<Integer> head){

        return head;
    }
    public static void main(String[] args) {
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n5 = new Node<>(5, n6);
        Node<Integer> n4 = new Node<>(4, n5);
        Node<Integer> n3 = new Node<>(4, n4);
        Node<Integer> n2 = new Node<>(1, n3);
        Node<Integer> n1 = new Node<>(1, n2);

        Node<Integer> node = removeDuplicates(n1);
        node.print();
    }
}
