package com.dsa.facebook;

public class Q_67_Add_Binary {

    //TC: O(m+n)
    //SC: O(1)
    public String addBinary(String a, String b) {
        String result ="";
        int sum = 0;

        int index1= a.length()-1;
        int index2= b.length()-1;

        char array1 [] = a.toCharArray();
        char array2 [] = b.toCharArray();

        while (index1 >=0 || index2 >= 0 || sum ==1 ){

            // compute the sume of last digit and carry
            int val1 = (index1 >= 0) ? array1[index1] - '0' : 0;
            sum = sum + val1;

            // compute the sume of last digit and carry
            int val2 = (index2 >= 0) ? array2[index2] - '0' : 0;
            sum = sum + val2;

            // if result is 1 or 3 then add 1 to result
            int val = sum%2;
            result = (char)(val + '0') + result;

            //compute carry
            sum = sum/2;

            // move the indexes
            index1--;
            index2--;

        }

        return result;
    }

    public static void main(String[] args) {
        String s1= "11";
        String s2= "1";

        Q_67_Add_Binary obj = new Q_67_Add_Binary();
        System.out.println(obj.addBinary(s1,s2));

    }
}
