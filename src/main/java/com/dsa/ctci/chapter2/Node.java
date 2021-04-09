package com.dsa.ctci.chapter2;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class Node<T> {
    Node<T> next;
    T data;

    public Node(final T data) {
        this.data = data;
        this.next = null;
    }
    public Node(final T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(final Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        //return "[ data : "+this.getData()+" | next: •-]-->";
        return "[ "+this.getData()+" | •-]-->";
    }

    public void print(){
        Objects.requireNonNull(this);
        Node<T> curr = this;
        while (curr != null){
            System.out.print(curr);
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println("");
    }

    public static Node<Integer> getSampleList(){
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n5 = new Node<>(5, n6);
        Node<Integer> n4 = new Node<>(4, n5);
        Node<Integer> n3 = new Node<>(3, n4);
        Node<Integer> n2 = new Node<>(2, n3);
        Node<Integer> n1 = new Node<>(1, n2);
        return n1;
    }
}
