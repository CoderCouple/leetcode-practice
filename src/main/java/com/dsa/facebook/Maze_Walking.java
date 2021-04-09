package com.dsa.facebook;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Maze_Walking {

    public List<Pair<Integer,Integer>> findPath(int [][] maze){
        List<Pair<Integer,Integer>> result = new ArrayList<>();
        findPath(maze,0,0, result);
        return result;
    }

    // DFS
    // TC: O(n) : n => number of elements in the matrix
    // SC: O(n)

    public boolean findPath(int [][] maze, int row, int col, List<Pair<Integer,Integer>> result){
        if(row <0 || row >= maze.length || col <0 || col >=maze[row].length)
            return false;

        if(maze[row][col] == 1)
            return false;

        if(maze[row][col] == 2)
            return false;

        if(row == maze.length-1 && col == maze[row].length-1){
            maze[row][col] = 2;
            result.add(Pair.of(row,col));
            return true;
        }

        Pair<Integer,Integer> curr = Pair.of(row,col);
        result.add(curr);
        maze[row][col] = 2;

        if(findPath(maze,row, col+1, result)) // Right
            return true;

        if(findPath(maze, row, col-1, result)) // Left
            return true;

        if(findPath(maze, row-1, col, result)) // Up
            return true;

        if(findPath(maze, row+1, col, result)) // Down
            return true;


        maze[row][col] = 0;
        result.remove(curr);

        return false;

    }


    // BFS
    // TC: O(n) : n => number of elements in the matrix
    // SC: O(n)

    public void findPathShortest(Object [][] maze){
        // because we will be traversing in reverse direction from target -> Source
        Stack<Pair<Integer,Integer>> result = new Stack<>();
        boolean isFound = findPathShortest(maze, result);


        if(isFound){
            Pair<Integer,Integer> target =  Pair.of(maze.length-1,maze[0].length-1);
            while (!(target.getLeft() == 0 && target.getRight() ==0)){
                result.push(target);
                target = (Pair<Integer, Integer>)maze[target.getLeft()][target.getRight()];
            }
        }

        while (!result.isEmpty()){
            Pair<Integer,Integer> curr = result.pop();
            System.out.println(curr);
            maze[curr.getLeft()][curr.getRight()] = "X";
        }

        //return result;
    }

    public boolean findPathShortest(Object [][] maze, List<Pair<Integer,Integer>> result){

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        Pair<Integer,Integer> source =  Pair.of(0,0);
        queue.add(source);
        maze[0][0] = source;

        while (!queue.isEmpty()){
            Pair<Integer,Integer> curr = queue.poll();
            int currRow = curr.getLeft();
            int currCol = curr.getRight();

            // checking if reached the target
            if( currRow == maze.length-1 && currCol == maze[0].length-1)
                return true;

            // generating the valid neighbours
            List<Pair<Integer,Integer>> neighbours = new ArrayList<>();
            for(int r =-1; r<=1; r++){
                for (int c=-1; c<=1; c++){
                    if( Math.abs(r) == Math.abs(c))
                        continue;
                    int newRow = currRow +r;
                    int newCol = currCol+c;
                    if( ( newRow>=0 && newRow < maze.length && newCol >= 0 && newCol < maze[newRow].length) && (maze[newRow][newCol].equals(0)) )
                      neighbours.add(Pair.of(newRow,newCol ));
                }
            }

            // Adding parent information for each child
            for(Pair<Integer,Integer> neighbour: neighbours){
                maze[neighbour.getLeft()][neighbour.getRight()] = curr;
                queue.add(neighbour);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Maze_Walking obj = new Maze_Walking();
        int [][] DFS_Maze = new int [][]{
                                        {0,0,0,0,0,0,0},
                                        {0,0,1,0,0,1,0},
                                        {0,0,1,0,1,1,0},
                                        {0,0,1,0,1,0,1},
                                        {1,1,1,0,0,0,0}
                                    };

        Object [][] BFS_Maze = new Object [][]{
                {0,0,0,0,0,0,0},
                {0,0,1,1,1,1,0},
                {0,0,1,0,0,0,0},
                {0,0,1,0,1,0,1},
                {1,1,1,0,0,0,0}
        };

        //System.out.println(obj.findPath(DFS_Maze));
        // (0, 0) -> (0, 1) -> (0, 2) -> (0, 3) -> (1, 3) -> (2, 3) -> (3, 3) -> (4, 3) -> (4, 4) -> (4, 5) -> (4, 6)
//        for(int [] arr : DFS_Maze){
//            System.out.println(Arrays.toString(arr));
//        }


        for(Object[] arr : BFS_Maze){
            System.out.println(Arrays.toString(arr));
        }

        obj.findPathShortest(BFS_Maze);

        for(Object[] arr : BFS_Maze){
            System.out.println(Arrays.toString(arr));
        }

    }
}
