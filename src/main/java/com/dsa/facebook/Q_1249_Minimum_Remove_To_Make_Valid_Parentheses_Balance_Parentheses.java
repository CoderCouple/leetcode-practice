package com.dsa.facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q_1249_Minimum_Remove_To_Make_Valid_Parentheses_Balance_Parentheses {

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexToDelete = new HashSet<Integer>();
        char [] array = s.toCharArray();
        for(int i =0; i<array.length; i++){
            if(array[i] == '('){
                stack.push(i);
            } else if(array[i] == ')'){
                if(stack.isEmpty()){
                    indexToDelete.add(i);
                }else{
                    stack.pop();
                }
            }
        }

        indexToDelete.addAll(stack);

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<array.length; i++){
            if(indexToDelete.contains(i)){
                continue;
            }
            sb.append(Character.toString(array[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(ab())c)"));
        System.out.println(minRemoveToMakeValid("))(("));
    }
}
