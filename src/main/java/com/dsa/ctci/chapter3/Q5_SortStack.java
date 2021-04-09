package com.dsa.ctci.chapter3;

import java.util.Stack;

public class Q5_SortStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);

        s.push(5);

        s.push(3);

        s.push(0);

        s.push(9);
        sortStack(s);
        System.out.println(s.peek());

    }

    public static void printStack(Stack<Integer> stack){
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println("");
    }

    public static void sortStack(Stack<Integer> s){
        Stack<Integer> anotherStack = new Stack<>();
        while (!s.isEmpty()){
            Integer temp = s.pop();

            while (!anotherStack.isEmpty() && anotherStack.peek()>temp){
                s.push(anotherStack.pop());
            }

            anotherStack.push(temp);
        }

        while (!anotherStack.isEmpty())
            s.push(anotherStack.pop());
    }
}
