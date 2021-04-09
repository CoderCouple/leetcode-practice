package com.dsa.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class TopK_Elements_From_N_Lists {

    public int [] getTopKElements(int[][] lists, int k){
        int [] result = new int [k];
        int [] index = new int [lists.length];
        boolean isInserted = false;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        if(lists == null || lists.length ==0){
            return result;
        }

        while(maxHeap.size()<k || isInserted){
            for(int i=0; i<lists.length;){

                if(index[i]>=lists[i].length){
                    isInserted = false;
                    i++;
                    continue;
                } else {
                    int curr = lists[i][index[i]];
                    if (maxHeap.size() < k) {
                        maxHeap.add(curr);
                        isInserted = true;
                    } else {
                        int max = maxHeap.peek();
                        if (max > curr) {
                            maxHeap.poll();
                            maxHeap.add(curr);
                            index[i]++;
                            isInserted = true;
                            continue;
                        } else {
                            isInserted = false;
                        }
                    }
                    index[i]++;
                    i++;
                }
            }
        }

       int j = k-1;
       while (!maxHeap.isEmpty()){
           result[j] = maxHeap.poll();
           j--;
       }

        return result;
    }

    public static void main(String[] args) {
        int [][] lists1 = new int[][] {   new int []{1,5,10,15,20},
                                        new int []{0,6,12,18},
                                        new int []{-5,-1,100,200}
                                    };

        int [][] lists2 = new int[][] {   new int []{-5}
                                        };

        TopK_Elements_From_N_Lists obj = new TopK_Elements_From_N_Lists();
        System.out.println(Arrays.toString(obj.getTopKElements(lists1, 5)));
        System.out.println(Arrays.toString(obj.getTopKElements(lists2, 1)));

    }
}
