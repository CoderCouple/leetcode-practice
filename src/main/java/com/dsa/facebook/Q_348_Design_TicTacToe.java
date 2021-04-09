package com.dsa.facebook;

import java.util.Arrays;

public class Q_348_Design_TicTacToe {

    /** Initialize your data structure here. */
    String [][] board;
    String [] players = {"X", "O"};
    int remainingMoves;

    int [][] rowTracker, colTracker;
    int [] d1, d2;
    int boardSize;


    public Q_348_Design_TicTacToe(int n) {
        board = new String[n][n];
        boardSize = n;
        remainingMoves = n*n;

        rowTracker = new int [2][n];
        colTracker = new int [2][n];
        d1 = new int [2];
        d2 = new int [2];

    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) throws Exception {
         if(row<0 || row >=boardSize || col<0 || col >=boardSize)
             throw new Exception("Invalid Move !");

         if(remainingMoves <= 0)
             throw new Exception("No More Moves Remaining!");

         if(board[row][col] != null &&  !board[row][col].isEmpty())
             throw new Exception("No Override Allowed !");

        board[row][col] = players[player-1];
        printBoard(board);
        remainingMoves--;

        rowTracker[player-1][row]++;
        colTracker[player-1][col]++;


        if(row == col)
            d1[player-1]++;

        if(row + col == boardSize-1)
            d2[player-1]++;

        if(d1[player-1] == boardSize || d2[player-1] == boardSize || rowTracker[player-1][row] == boardSize || colTracker[player-1][col] == boardSize)
            return player;

        return 0;
    }

    public void printBoard(String [][] board){
        System.out.println(Arrays.deepToString(board));
    }

    public static void main(String[] args) throws Exception {
        Q_348_Design_TicTacToe ticTacToe= new Q_348_Design_TicTacToe(3);
        System.out.println(ticTacToe.move(0, 0, 1));
        System.out.println(ticTacToe.move(0, 2, 2));
        System.out.println(ticTacToe.move(2, 2, 1));
        System.out.println(ticTacToe.move(1, 1, 2));
        System.out.println(ticTacToe.move(2, 0, 1));
        System.out.println(ticTacToe.move(1, 0, 2));
        System.out.println(ticTacToe.move(2, 1, 1));

    }

}

/**
 * Your Q_348_Design_TicTacToe object will be instantiated and called as such:
 * Q_348_Design_TicTacToe obj = new Q_348_Design_TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
