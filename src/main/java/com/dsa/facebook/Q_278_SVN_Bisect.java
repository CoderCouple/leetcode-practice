package com.dsa.facebook;

public class Q_278_SVN_Bisect {
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start<=end){
            mid = start + (end-start)/2;
            if(!isBadVersion(mid-1) && isBadVersion(mid)){
                return mid;
            } else if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return mid;
    }

    public boolean isBadVersion(int version){
        return version%2==0;
    }
}
