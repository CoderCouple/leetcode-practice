package com.dsa.ctci.chapter10;

import java.util.ArrayList;
import java.util.List;

public class Q4_SortedSearch {

    public int search(Listly list, int element){
        if(list.elementAt(0) == element)
            return 0;

        int prevIndex =0;
        int currIndex =1;
        while (true){
            if(list.elementAt(currIndex) == element)
                return currIndex;
            else if(list.elementAt(currIndex) == -1){
                int innerIndex = prevIndex;
                while(list.elementAt(innerIndex) != -1){
                    if(list.elementAt(innerIndex) == element)
                        return innerIndex;

                    innerIndex++;
                }
            } else {
                return binarySearch(list,prevIndex,currIndex,element);
            }
            prevIndex = currIndex;
            currIndex = currIndex*2;
        }
    }

    public int search1(Listly list, int element){
        int index =1;
        while (list.elementAt(index) != -1 && list.elementAt(index)<element){
            index = index*2;
        }
        return binarySearch(list,index/2,index,element);
    }

    public int binarySearch(Listly list, int left, int right, int element){
       int mid = left + (right -left)/2;
       while (left<=right){
           if(list.elementAt(mid) ==-1 || element < list.elementAt(mid)){
               right = mid-1;
           } else if(list.elementAt(mid)> element){
               left = mid+1;
           } else{
               return mid;
           }
       }
       return -1;
    }

    public static void main(String[] args) {

    }
}

class Listly{
    List<Integer> list = new ArrayList<>();

    public Integer elementAt(int index){
        try {
            return list.get(index);
        } catch (IndexOutOfBoundsException e){
            return -1;
        }
    }
}
