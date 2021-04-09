package com.dsa.leetcode.ch2_linked_lists;

import java.util.Objects;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        //return "[ data : "+this.getData()+" | next: •-]-->";
        return "[ "+this.val+" | •-]-->";
    }

    public void print(){
        Objects.requireNonNull(this);
        ListNode curr = this;
        while (curr != null){
            System.out.print(curr);
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println("");
    }
}
