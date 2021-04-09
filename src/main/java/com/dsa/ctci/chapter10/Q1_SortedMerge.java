package com.dsa.ctci.chapter10;

import java.util.Arrays;

public class Q1_SortedMerge {

    public int [] merge(int A[] , int B [], int indexA, int indexB){
        if((A == null || A.length==0) && (B == null || B.length==0))
            return null;
        if(A == null || A.length==0)
            return B;
        if(B == null || B.length==0)
            return A;

        int mergeIndex = indexA+indexB-1;

        while(indexB-1>= 0){
            if(A[indexA-1] >= B[indexB-1]){
                A[mergeIndex] = A[indexA-1];
                indexA--;
            } else {
                A[mergeIndex] = B[indexB-1];
                indexB--;
            }
            mergeIndex--;
        }
        return A;
    }

    public static void main(String[] args) {
        int [] A = { 1,2,3,0,0,0,0,0 };
        int [] B = { 4,5,6 };

        Q1_SortedMerge obj = new Q1_SortedMerge();
        System.out.println(Arrays.toString(obj.merge(A,B,3,3)));
    }
}
