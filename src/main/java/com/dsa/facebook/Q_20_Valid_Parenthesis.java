package com.dsa.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q_20_Valid_Parenthesis {
    public static boolean isValid(String s) {
        Map<Character, Character> openToCloseMap = new HashMap<>();
        openToCloseMap.put('[',']');
        openToCloseMap.put('(',')');
        openToCloseMap.put('{','}');

        Map<Character,Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(']','[');
        closeToOpenMap.put(')','(');
        closeToOpenMap.put('}','{');

        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(openToCloseMap.containsKey(c)){
                stack.push(c);
            } else if(closeToOpenMap.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == closeToOpenMap.get(c))
                    stack.pop();
                else return false;

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("[[]]"));
        System.out.println(isValid("{{}{}}"));
        System.out.println(isValid("(()([))"));
    }
}
