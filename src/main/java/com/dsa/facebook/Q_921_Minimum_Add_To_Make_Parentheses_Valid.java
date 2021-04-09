package com.dsa.facebook;

public class Q_921_Minimum_Add_To_Make_Parentheses_Valid {
    public int minAddToMakeValid(String S) {
        int open = 0;
        int res = 0;
        for(char c : S.toCharArray()){
            if(c == '('){
                open++;
                res++;
            } else{
                if(open>0){
                    open--;
                    res--;
                } else{
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
