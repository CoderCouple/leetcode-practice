package com.dsa.ctci.chapter3;

import java.util.Stack;

public class Q4_QueueOfStacks {
    public static void main(String[] args) {
        MyQueue<String> q = new MyQueue<>();
        q.offer("Sunil");
        q.offer("Payal");
        System.out.println(q.peek());
        System.out.println(q.poll());
        q.offer("Katha");
    }

}

class MyQueue<T>{
    private Stack<T> oldStack;
    private Stack<T> newStack;

    public MyQueue() {
        this.oldStack = new Stack<>();
        this.newStack = new Stack<>();
    }

    public void offer(final T element){
        newStack.push(element);
    }

    public T poll(){
        shiftElements();
        if(!oldStack.isEmpty())
            return oldStack.pop();
        return null;
    }

    public T peek(){
        shiftElements();
        if(!oldStack.isEmpty())
            return oldStack.peek();
        return null;
    }

    private void shiftElements(){
        if(oldStack.isEmpty()){
            while (!newStack.isEmpty()){
                oldStack.push(newStack.pop());
            }
        }
    }

    public boolean isEmpty(){
        return (oldStack.size()+newStack.size()) == 0;
    }
}