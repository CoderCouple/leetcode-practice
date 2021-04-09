package com.dsa.ctci.chapter1;

public class Q7_RotateMatrix {

    public static void rotateMatrix(final int [][] matrix){
        if(matrix == null || matrix.length ==0 || matrix.length != matrix[0].length){
            System.err.println("Sorry! Can not rotate the matrix!");
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int noOfLayers  =  (row/2);
        int [] buffer = new int [row];

        for (int layer =0; layer< noOfLayers; layer++){
            int i = layer;
            int j;
            int k;
            int l;

            //for(int m)


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
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        print2DArray(matrix);
    }
}
