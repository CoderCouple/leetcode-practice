package com.dsa.facebook;

public class Q_304_Range_Sum_Query_2D_Immutable {
    public static void main(String[] args) {
        int [][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix m = new NumMatrix(matrix);
        m.printMatrix();
        System.out.println(m.sumRegion(2,1,4,3));
        System.out.println(m.sumRegion(1, 1, 2, 2));
        System.out.println(m.sumRegion(1, 2, 2, 4));
    }
}


class NumMatrix {

    int [][] cumulativeMatrix;
    int row;
    int col;

    public NumMatrix(int[][] matrix) {
        if(matrix != null && matrix.length !=0){
            row = matrix.length;
            col = matrix[0].length;
        }
        cumulativeMatrix = new int [row+1][col+1];
        populateCumulativeMatrix(matrix);
    }

    public void populateCumulativeMatrix(int[][] matrix){
        if(matrix == null && matrix.length ==0)
            return;

        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                cumulativeMatrix[row+1][col+1] = cumulativeMatrix[row][col+1] + cumulativeMatrix[row+1][col] + matrix[row][col] - cumulativeMatrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return cumulativeMatrix[row2+1][col2+1] - cumulativeMatrix[row2+1][col1] - cumulativeMatrix[row1][col2+1] + cumulativeMatrix[row1][col1];
    }

    public void printMatrix(){
        int [][] matrix = this.cumulativeMatrix;
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                System.out.print("| "+matrix[row][col]+" ");
            }
            System.out.println("");
        }
    }
}
