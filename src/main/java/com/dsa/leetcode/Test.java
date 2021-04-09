package com.dsa.leetcode;

public class Test {
    public static int countHi(String str) {
        return countHiHelper(str,0, "hi");
    }

    public static int countHiHelper(String str, int index, String match){
        if(str.length()-index  <= 1)
            return 0;

        String currStr = str.substring(index,index+match.length());
        int count = currStr.equals(match) ? 1: 0;
        return count + countHiHelper(str, index+1, match);
    }

    public static void main(String[] args) {
        System.out.println(countHi("xhixhix"));
    }
}
