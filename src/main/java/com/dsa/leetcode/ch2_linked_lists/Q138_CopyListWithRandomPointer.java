package com.dsa.leetcode.ch2_linked_lists;

import java.util.HashMap;
import java.util.Map;

public class Q138_CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node myHead = new Node(0);
        Node ptr = myHead;
        if(head == null)
            return head;

        Node curr = head;

        while(curr != null){
            Node n = new Node(curr.val);
            map.put(curr, n);
            ptr.next = n;
            ptr = ptr.next;
            curr = curr.next;
        }

        curr = head;
        ptr = myHead.next;

        while(curr != null){
            Node n = map.getOrDefault(curr.random,null);
            ptr.random = n;
            ptr = ptr.next;
            curr = curr.next;
        }

        return myHead.next;
    }

    public static void main(String[] args) {

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}