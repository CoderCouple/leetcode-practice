package com.dsa.ctci.chapter3;

import java.util.Stack;

public class Q3_StackOfPlates {
    public static void main(String[] args) throws Exception {

        SetOfStacks s = new SetOfStacks(5);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        s.push(6);
        s.push(7);

        s.pop();
        s.pop();
        s.pop();

        s.push(8);
        s.push(9);
    }
}

class SetOfStacks{
    private final int capacity;
    private int size;
    private Stack<Stack<Integer>> stackOfStacks;

    public SetOfStacks() {
        this.capacity = 3;
        this.size = 0;
        this.stackOfStacks = new Stack<>();
    }
    public SetOfStacks(final int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.stackOfStacks = new Stack<>();
    }

    public void push(final Integer element){
        if(stackOfStacks.isEmpty() || size == capacity){
            Stack<Integer> stack = new Stack<>();
            stackOfStacks.push(stack);
            size =0;
        }
        stackOfStacks.peek().push(element);
        size++;
    }

    public Integer pop() throws Exception {
        Integer res = -9999;
        if(stackOfStacks.isEmpty()){
            throw new Exception("No element to pop!");
        } else {
            if (stackOfStacks.peek().isEmpty()) {
                stackOfStacks.pop();
                if (stackOfStacks.isEmpty()) {
                    throw new Exception("No element to pop!");
                } else {
                    res = stackOfStacks.peek().pop();
                }
            } else {
                res = stackOfStacks.peek().pop();
            }
        }
        size--;
        if(size<0)
            size = capacity-1;
        return res;
    }
}
