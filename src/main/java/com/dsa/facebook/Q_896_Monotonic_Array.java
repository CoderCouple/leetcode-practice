package com.dsa.facebook;

public class Q_896_Monotonic_Array {

    public boolean isMonotonic(int[] A) {

        if(A.length == 0)
            return false;

        boolean inc = false;
        boolean dec = false;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i+1] > A[i]) inc = true;
            if (A[i+1] < A[i]) dec = true;
            if (inc && dec) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Q_896_Monotonic_Array obj = new Q_896_Monotonic_Array();
        System.out.println(obj.isMonotonic(new int [] {1,2,2,3}));
        System.out.println(obj.isMonotonic(new int [] {1,3,2}));
    }
}
