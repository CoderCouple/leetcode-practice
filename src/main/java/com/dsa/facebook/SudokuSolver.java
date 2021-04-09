package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {
    char[][] board;
    int boxSize = 3;
    int rowLength;
    int colLength;

    //this will keep track of the elements in that row, col and sub matrix
    List<Set<Character>> rowSets;
    List<Set<Character>> colSets;
    List<Set<Character>> subMatrixSets;

    public void setup(char[][] board) {
        this.board = board;
        this.rowLength = board.length;
        this.colLength = board[0].length;

        rowSets = new ArrayList<>();
        colSets = new ArrayList<>();
        subMatrixSets = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
            colSets.add(new HashSet<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
            subMatrixSets.add(new HashSet<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
        }

    }

    public boolean solveSudoku(char[][] board) {
        setup(board);
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (board[r][c] != '.')
                    remove(r, c);
            }
        }
        return backtracking(0,0);
    }

    public boolean backtracking(int r, int c) {
        if(r >= rowLength)
            return true;


        for(int col=0; col<colLength; col++){

        }


        int [] pos = new int[]{r,c};
        if(c >= colLength){
            pos =getNextPosition(r,c);
            return backtracking(pos[0],pos[1]);
        }


        while(board[pos[0]][pos[1]] != '.'){
            pos =getNextPosition(pos[0],pos[1]);
        }

        Set<Character> set = getIntersection(pos[0], pos[1]);
            if (set.isEmpty()) {
                return false;
            }

        for (char ch : set) {
                board[pos[0]][pos[1]] = ch;
                remove(pos[0], pos[1]);


                pos =getNextPosition(pos[0],pos[1]);
                if (backtracking(pos[0],pos[1]))
                    return true;

                add(r, c);
                board[r][c] = '.';
            }

        return false;
    }

//    public boolean backtracking(int r, int c) {
//        if(r >= rowLength)
//            return true;
//
//
//        int [] pos = new int[]{r,c};
//        if(c >= colLength){
//            pos =getNextPosition(r,c);
//            return backtracking(pos[0],pos[1]);
//        }
//
//
//        while(board[pos[0]][pos[1]] != '.'){
//            pos =getNextPosition(pos[0],pos[1]);
//        }
//
//        Set<Character> set = getIntersection(pos[0], pos[1]);
//        if (set.isEmpty()) {
//            return false;
//        }
//
//        for (char ch : set) {
//            board[pos[0]][pos[1]] = ch;
//            remove(pos[0], pos[1]);
//
//
//            pos =getNextPosition(pos[0],pos[1]);
//            if (backtracking(pos[0],pos[1]))
//                return true;
//
//            add(r, c);
//            board[r][c] = '.';
//        }
//
//        return false;
//    }

    public int [] getNextPosition(int row, int col){
        int nextCol = col;
        int nextRow = row;
        if(col >= colLength){
            nextCol =0;
            nextRow = row+1;
        } else {
            nextCol =col+1;
        }
        return new int [] {nextRow,nextCol};
    }

//    public boolean backtracking(int r, int c) {
//
//        System.out.println("backtracking call " + r + "," + c);
//        if (r >= rowLength)
//            return true;
//
//        int cNext ;
//        int rNext ;
//        if(c < colLength-1) {
//            cNext = c + 1;
//            rNext = r;
//        }
//        else  {
//            rNext = r + 1;
//            cNext = 0;
//        }
//
//        if(board[r][c] != '.')
//            backtracking(rNext, cNext);
//        if (board[r][c] == '.') {
//            Set<Character> set = getIntersection(r, c);
//            if (set.isEmpty()) {
//                return false;
//            }
//            for (char ch : set) {
//                board[r][c] = ch;
//                System.out.println("board char " + r + "," + c + ":" + board[r][c]);
//                remove(r, c);
//
//
//                if (backtracking(rNext, cNext))
//                    return true;
//
//                add(r, c);
//                board[r][c] = '.';
//            }
//            return false;
//        }
//
//        return false;
//    }

    // adds element to row, col and sub matrix.
    public void add(int row, int col) {
        rowSets.get(row).add(this.board[row][col]);
        colSets.get(col).add(this.board[row][col]);
        int subMatrixIndex = (row / 3) * boxSize + (col / 3);
        subMatrixSets.get(subMatrixIndex).add(this.board[row][col]);
    }

    // removes element from row, col and sub matrix.
    public void remove(int row, int col) {
        rowSets.get(row).remove(this.board[row][col]);
        colSets.get(col).remove(this.board[row][col]);
        int subMatrixIndex = (row / 3) * boxSize + (col / 3);
        subMatrixSets.get(subMatrixIndex).remove(this.board[row][col]);
    }

    // get the inter section of all the 3 : row, col & subMatrix
    public Set<Character> getIntersection(int row, int col) {
        Set<Character> set = new HashSet<>();
        int subMatrixIndex = (row / 3) * boxSize + (col / 3);
        for (char c : subMatrixSets.get(subMatrixIndex)) {
            if (rowSets.get(row).contains(c) && colSets.get(col).contains(c)) {
                set.add(c);
            }
        }
        return set;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        SudokuSolver solver = new SudokuSolver();
        System.out.println(solver.solveSudoku(board));
        System.out.println(Arrays.deepToString(board));
    }
}
