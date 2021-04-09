package com.dsa.facebook;

public class Q_277_Find_The_Celebrity implements Relation {

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    //TC: O(n)
    //SC: O(1)
    public int findCelebrity(int n) {
        int start = 0;
        int end = n-1;


        while(start != end){        //               knows
            if(knows(start, end)){  // does start ----------> end if yes then start is not the celebriity
                start++;            //                            if no then end is not the celebriity
            } else {
                end--;
            }
        }


        // This part is neeeded only if there is a chance that the list contains no celebrity
        for(int i=0; i<n; i++){

            if(start == i )
                continue;

            if(!knows(i, start) || knows(start, i))
                return -1;
        }

        return start;
    }

    @Override
    public boolean knows(final int a, final int b) {
        return false;
    }
}

interface Relation{
    boolean knows(int a, int b);
}