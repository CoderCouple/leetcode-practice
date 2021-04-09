package com.dsa.facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Select_Kth_Largest_Element {


    // TC: O(nlogk)
    // SC : O(n)
    public int getKthLargestElement(int [] array, int k){
        if(array.length == 0)
            return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, Comparator.naturalOrder());
        for(int element : array){
            if(minHeap.size() < k){
                minHeap.add(element);
            } else{
                minHeap.add(element);
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int [] array = new int [] {1,3,5,9};
        Select_Kth_Largest_Element obj = new Select_Kth_Largest_Element();
        System.out.println(obj.getKthLargestElement(array, 3));
    }
}
