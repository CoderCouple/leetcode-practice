package com.dsa.facebook;

public class CountInterpretations {

    // TC: O(2^n)
    // SC: O(n)
    public int countInterpretations(char [] input, int index, int dp []){
        int count =0;
        if(index > input.length)
            return 0;

        if(index == input.length-1 || index == input.length)
            return 1;
        else if(input[index] =='0')
            count =0;
        else if(dp[index] != 0)
            return dp[index];
        else {
            int first = Integer.parseInt(input[index]+"");
            if( first<= 9 && first>=1)
                count = countInterpretations(input, index+1, dp);

            int second = Integer.parseInt(input[index]+""+input[index+1]);
            if( second>= 10 && second<=26)
                count = count + countInterpretations(input, index+2, dp);

        }
        dp[index] = count;
        return count;
    }
    public static void main(String[] args) {
        CountInterpretations obj = new CountInterpretations();
        char [] input = new char []{'1','2','1','2','1'};
        int [] dp = new int[input.length];
        System.out.println(obj.countInterpretations(input,0, dp));

    }
}
