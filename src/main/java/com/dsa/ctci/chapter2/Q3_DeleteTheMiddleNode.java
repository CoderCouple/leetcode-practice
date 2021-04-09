package com.dsa.ctci.chapter2;

import java.util.Objects;

public class Q3_DeleteTheMiddleNode {

    public static void deleteTheNode(Node<Integer> node){
        Objects.requireNonNull(node,"Node can not be null");
        Node<Integer> prev = null;
        Node<Integer> curr = node;
        while (curr.next != null){
            int temp = curr.next.data;
            curr.data = temp;
            prev  = curr;
            curr = curr.next;
        }

        prev.next = null;
    }

    public static void main(String[] args) {
        Node<Integer> node  =  Node.getSampleList();
        Node<Integer> data = node.next.next.next;
        System.out.println(data);
        deleteTheNode(data);
        node.print();
    }
}
