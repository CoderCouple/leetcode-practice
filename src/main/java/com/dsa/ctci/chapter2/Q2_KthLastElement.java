package com.dsa.ctci.chapter2;

public class Q2_KthLastElement {

    public static Node<Integer> findKthLastNode(final Node<Integer> head, final int k){
        if(head == null || k <= 0)
            return head;
        Node<Integer> curr = head;
        Node<Integer> prev = head;
        int counter = k;
        while (curr != null){
            if(0 == counter){
                prev = prev.next;
            } else {
                counter--;
            }
            curr = curr.next;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node.getSampleList().print();
        System.out.println(findKthLastNode(Node.getSampleList(),3));
    }
}
