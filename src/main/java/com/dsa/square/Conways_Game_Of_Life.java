package com.dsa.square;

import java.util.Arrays;

public class Conways_Game_Of_Life {

    /*
    Time Complexity: O(M X N), where M is the number of rows anNN is the number of columns of the Board.
    Space Complexity: O(M X N), where M is the number of rows and N is the number of columns of the Board.
    This is the space occupied by the copy board we created initially.
    * */

    //https://www.geeksforgeeks.org/program-for-conways-game-of-life/
    //https://leetcode.com/problems/game-of-life/solution/
    public int[][] getNextGenBoard(int board[][]){
        if(board == null || board.length ==0)
            return new int[0][0];

        int row = board.length;
        int col = board[0].length;

        int[][] nextGenBoard = new int[row][col];

        for(int r=0; r<row; r++){
            for (int c=0; c<col; c++){
                int aliveNeighbours = 0;

                for(int rowVal =-1; rowVal<=1; rowVal++){
                    for(int colVal =-1; colVal<=1; colVal++){
                        int nr = r+rowVal;
                        int nc = c+colVal;
                        if(nr < 0 || nr >= row || nc < 0 || nc >=col)
                            continue;
                        aliveNeighbours = aliveNeighbours+board[nr][nc];
                    }
                }

                // to remove the self, counted as neighbours
                aliveNeighbours = aliveNeighbours - board[r][c];

                    // Cell dies due to under population
                if ((board[r][c] == 1) && (aliveNeighbours < 2))
                    nextGenBoard[r][c] = 0;

                    // Cell dies due to over population
                else if ((board[r][c] == 1) && (aliveNeighbours > 3))
                    nextGenBoard[r][c] = 0;

                    // A new cell is born
                else if ((board[r][c] == 0) && (aliveNeighbours == 3))
                    nextGenBoard[r][c] = 1;

                    // Remains the same
                else
                    nextGenBoard[r][c] = board[r][c];
            }

        }
        return nextGenBoard;
    }

    public static void main(String[] args) {

        Conways_Game_Of_Life obj = new Conways_Game_Of_Life();
        int [][] board = new int [][]{{1,0},{0,0}};
        System.out.println(Arrays.deepToString(obj.getNextGenBoard(board)));
    }


}
