package com.dsa.ctci.chapter1;

import java.util.Arrays;

// Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to O.
public class Q8_ZeroMatrix {
    public static void makeZeroMatrix(final int[][] matrix){

        if(matrix == null)
            return;

        int row = matrix.length;
        int col = matrix[0].length;

        int [] rowTracker = new int[row];
        int [] colTracker = new int[col];

        for(int r=0; r<row; r++){
            for (int c=0; c<col; c++){
               if(matrix[r][c] == 0){
                   rowTracker[r] = 1;
                   colTracker[c] = 1;
               }
            }
        }
        makeRowZero(matrix,rowTracker);
        makeColumnZero(matrix,colTracker);
    }

    public static void makeRowZero(final int[][] matrix, final int[] rowTracker){
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0; i<r; i++){
            if(rowTracker[i] == 1){
                for(int j=0; j<c; j++){
                    matrix[i][j] =0;
                }
            }
        }
    }

    public static void makeColumnZero(final int[][] matrix, final int[] colTracker){
        int r = matrix.length;
        int c = matrix[0].length;
        for(int j=0; j<c; j++){
            if(colTracker[j] == 1){
                for(int i=0; i<r; i++){
                    matrix[i][j] =0;
                }
            }
        }
    }

    private static void print2DArray(final int[][] matrix) {
        for( int [] row : matrix){
            for(int element : row){
                System.out.print(element+ " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {
                            {0,2,3},
                            {4,0,6},
                            {7,8,9}
                           };
        makeZeroMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
        print2DArray(matrix);
    }

}
