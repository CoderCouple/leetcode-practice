package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=HLOYeHXKz1w
public class NQueens {
    int n;
    int [] queens;
    boolean[] rowTracker;
    boolean[] colTracker;
    boolean[] upDiagonalTracker;
    boolean[] downDiagonalTracker;
    List<List<String>> result;

    char [][] board;

    public void setup(int n) {
        this.n = n;
        rowTracker = new boolean[n];
        colTracker = new boolean[n];
        upDiagonalTracker = new boolean[2 * n];
        downDiagonalTracker = new boolean[2 * n];
        result = new ArrayList<>();
        queens = new int[n];

        board = new char[n][n];
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                board[r][c] = '.';
            }
        }

        printBoard();
    }

    public List<List<String>> solveNQueens(int n) {
        setup(n);
        backtracking(0);
        return this.result;
    }

    public void backtracking(int row) {
        if(row >= this.n){
            addResult();
            printBoard();
            return;
        }

        for(int col =0; col<this.n; col++){
            if(!isUnderAttack(row,col)){
                placeQueen(row,col);
                //printBoard();
                backtracking(row+1);
                removeQueen(row,col);
            }
        }
    }

    public void placeQueen(int row, int col){
        this.board[row][col] = 'Q';
        this.rowTracker[row] = true;
        this.colTracker[col] = true;
        this.queens[row] = col;
        this.upDiagonalTracker[row+col] = true;
        this.downDiagonalTracker[row-col+this.n-1] = true;
    }

    public void removeQueen(int row, int col){
        this.board[row][col] = '.';
        this.rowTracker[row] = false;
        this.colTracker[col] = false;
        this.queens[row] = 0;
        this.upDiagonalTracker[row+col] = false;
        this.downDiagonalTracker[row-col+this.n-1] = false;
    }

    public boolean isUnderAttack(int row, int col){
        return  this.rowTracker[row] || this.colTracker[col] || this.upDiagonalTracker[row+col] || this.downDiagonalTracker[row-col+this.n-1];
    }

    private void addResult() {
        List<String> list = new ArrayList<>();
        for(int row =0; row<this.n; row++){
            StringBuilder sb = new StringBuilder();
            for(int col =0; col < this.n; col++){
                if(queens[row] == col)
                    sb.append("Q");
                else
                    sb.append(".");
            }
            list.add(sb.toString());
        }
        result.add(list);
    }

    public void printBoard(){
        System.out.println("----------------------------------");
        for(int r=0; r<n; r++){
            System.out.print("|");
            for(int c=0; c<n; c++){
                System.out.print(board[r][c]+"|");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        NQueens game = new NQueens();
        System.out.println(game.solveNQueens(4));
    }
}
