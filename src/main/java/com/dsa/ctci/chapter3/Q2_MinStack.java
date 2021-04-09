package com.dsa.ctci.chapter3;

import java.util.Stack;

public class Q2_MinStack {
    public static void main(String[] args) {
        CustomMinStack stack = new CustomMinStack<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(2);
        stack.push(7);
        System.out.println(stack.min()); // 2
        System.out.println(stack.pop()); // 7
        System.out.println(stack.pop()); // 2
        System.out.println(stack.min()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.min()); // 3
    }
}

class CustomMinStack<T extends Number>{

    private final Stack<T> data;
    private final Stack<T> min;

    public CustomMinStack() {
        this.data = new Stack<T>();
        this.min = new Stack<T>();
    }

    public void push(final T element){
        if(min.isEmpty()){
            min.push(element);
        } else{
            if(min.peek().intValue() >= element.intValue())
                min.push(element);
        }
        data.push(element);
    }

    public T pop(){
        if(!data.isEmpty()){
           T element = data.pop();;
           if(element == min.peek())
               min.pop();
           return element;
        } else {
            System.err.println("Stack is empty!");
            return null;
        }
    }

    public T min(){
        if(!min.isEmpty()){
            return min.peek();
        } else {
            System.err.println("Min value not found!");
            return null;
        }
    }
}