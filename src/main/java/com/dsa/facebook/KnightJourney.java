package com.dsa.facebook;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightJourney {

    //infinite board
    public static int find(Pair<Integer, Integer> source, Pair<Integer, Integer> target, Set<Pair<Integer, Integer>> obstacles){
        Queue<Triple<Integer, Integer, Integer>> queue = new LinkedList<>();
        Set<Triple<Integer, Integer, Integer>> isVisited = new HashSet<>();

        queue.add(Triple.of(source.getLeft(), 0, source.getRight()));


        while (!queue.isEmpty()){
            Triple curr = queue.poll();

            isVisited.add(curr);
            // check if target is found or not
            if(curr.getLeft() == target.getLeft() && curr.getRight() == target.getRight())
                return (int) curr.getMiddle();

            // get Neighbours
            for(int row = -2; row<=2; row++){
                for(int col =-2; col<=2; col++){
                    if(Math.abs(row) + Math.abs(col) == 3){
                        int newRow = row + (int)curr.getLeft();
                        int newCol = col + (int)curr.getRight();
                        if(isValidIndex(newRow, newCol) && !isVisited.contains(Triple.of(newRow,(int)curr.getMiddle()+1, newCol)) && !obstacles.contains(Pair.of(newRow,newCol))){
                            queue.add(Triple.of(newRow,(int)curr.getMiddle()+1, newCol));

                        }
                    }
                }
            }

        }

        return -1;
    }

    private static boolean isValidIndex(int row, int col) {
        int size = 8;
        if(row>=0 && row<size && col>=0 && col<size)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Set<Triple<Integer, Integer, Integer>> isVisited = new HashSet<>();

        KnightJourney obj = new KnightJourney();
        Set<Pair<Integer, Integer>> obstacles = new HashSet<>();
        obstacles.add(Pair.of(2,3));
        obstacles.add(Pair.of(2,4));

        obstacles.add(Pair.of(3,4));
        obstacles.add(Pair.of(3,5));

        obstacles.add(Pair.of(4,5));

        obstacles.add(Pair.of(5,5));

        System.out.println(obj.find(Pair.of(4,3), Pair.of(2,6),obstacles));
        //isVisited.add(new ImmutableTriple<Integer, Integer, Integer>(1,1,1));
        //System.out.println(isVisited.contains(new ImmutableTriple<Integer,Integer,Integer>(1,1,1)));
    }
}

