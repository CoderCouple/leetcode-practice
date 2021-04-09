package com.dsa.leetcode.ch2_linked_lists;

import com.dsa.ctci.chapter2.Node;

import java.util.Objects;

public class MyLinkedList {

    /** Initialize your data structure here. */
    LinkedListNode head;
    LinkedListNode tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 ||index>=size)
            return -1;
        LinkedListNode curr = head;
        int counter = 0;
        while(counter!=index){
            curr = curr.next;
            counter++;
        }
        return curr.val;
    }

    /** Add PowerOfTwo node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkedListNode n = new LinkedListNode(val);
        if(head == null){
            head =n;
            tail =n;
        } else {
            n.next = head;
            head = n;
        }

        size++;
    }

    /** Append PowerOfTwo node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LinkedListNode n = new LinkedListNode(val);
        if(tail == null){
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = tail.next;
        }

        size++;
    }

    /** Add PowerOfTwo node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0 ||index>size)
            return;

        if(index==0){
            addAtHead(val);
            return;
        }


        if(index==size){
            addAtTail(val);
            return;
        }



        LinkedListNode curr = head;

        int counter = 1;
        while(counter<index){
            curr = curr.next;
            counter++;
        }

        LinkedListNode n = new LinkedListNode(val);
        n.next = curr.next;
        curr.next = n;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0 ||index>=size)
            return;

        LinkedListNode curr = head;
        LinkedListNode prev = null;
        int counter = 0;
        while(counter!=index){
            prev = curr;
            curr = curr.next;
            counter++;
        }


        if(head == tail)
            return;

        if(curr == head){
            head = head.next;
            size --;
            return;
        }

        if(curr == tail){
            prev = tail;
            size--;
            return;
        }

        prev.next  = curr.next;
        size--;
    }

    public void printList(){
      if(head != null)
          head.print();
    }

    /*

     ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
     [[],[1],[3],[1,2],[1],[1],[1]]

     Your answer
     [null,null,null,null,3,null,3]

     Expected answer
     [null,null,null,null,2,null,3]

    */
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.printList();
        obj.addAtTail(3);
        obj.printList();
        obj.addAtIndex(1,2);
        obj.printList();
        System.out.println(obj.get(1));
        obj.printList();
        obj.deleteAtIndex(0);
        obj.printList();
        obj.get(0);
        obj.printList();

    }
}

class LinkedListNode{
    int val;
    LinkedListNode next;

    public LinkedListNode(final int val) {
        this.val = val;
    }

    public LinkedListNode(final int val, final LinkedListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(final int val) {
        this.val = val;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(final LinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        //return "[ data : "+this.getData()+" | next: •-]-->";
        return "[ "+this.val+" | •-]-->";
    }

    public void print(){
        Objects.requireNonNull(this);
        LinkedListNode curr = this;
        while (curr != null){
            System.out.print(curr);
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println("");
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */