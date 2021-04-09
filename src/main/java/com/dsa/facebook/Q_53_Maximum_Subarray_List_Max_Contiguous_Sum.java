package com.dsa.facebook;

public class Q_53_Maximum_Subarray_List_Max_Contiguous_Sum {

    public int maxSubArray(int[] array) {

        if(array.length == 0)
            return 0;

        int globalMaxima = array[0];
        int localMaxima = array[0];

        for(int i=1; i<array.length; i++){
            localMaxima  = Math.max(array[i], localMaxima+array[i]);
            globalMaxima =  Math.max(localMaxima,globalMaxima);
        }
        return globalMaxima;
    }

    public static void main(String[] args) {
        Q_53_Maximum_Subarray_List_Max_Contiguous_Sum obj = new  Q_53_Maximum_Subarray_List_Max_Contiguous_Sum();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(obj.maxSubArray(new int[]{1}));

        System.out.println(obj.maxSubArray(new int[]{0}));

        System.out.println(obj.maxSubArray(new int[]{-1}));

        System.out.println(obj.maxSubArray(new int[]{-100000}));
    }
}
