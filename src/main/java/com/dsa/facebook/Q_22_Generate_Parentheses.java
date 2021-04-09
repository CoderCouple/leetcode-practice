package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q_22_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getCombination(n,0,0,new StringBuilder(),result);
        return result;
    }

    public void getCombination(int n, int open, int close, StringBuilder curr, List<String> result){
        if(n == open && n == close){
            result.add(curr.toString());
            return;
        }

        if(open> n || close >n)
            return;

        if(close > open)
            return;

        curr.append("(");
        getCombination(n,open+1,close,curr,result);

        curr.deleteCharAt(curr.length()-1);
        curr.append(")");

        getCombination(n,open,close+1,curr,result);

        curr.deleteCharAt(curr.length()-1);
    }
}
