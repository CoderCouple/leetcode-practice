package com.dsa.facebook;

import java.util.Arrays;

public class Q_59_Spiral_Matrix_II {

    // TC: O(n) n: number of elements in the matrix
    // SC: O(n)
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        if (n == 0) {
            return matrix;
        }

        int rowStart = 0;
        int colStart = 0;
        int colEnd = n - 1;
        int rowEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int col = colStart; col <= colEnd; col++) {
                    matrix[rowStart][col] = count++;
                }
                rowStart++;
            }

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int row = rowStart; row <= rowEnd; row++) {
                    matrix[row][colEnd] = count++;
                }
                colEnd--;
            }

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    matrix[rowEnd][col] = count++;
                }
                rowEnd--;
            }

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    matrix[row][colStart] = count++;
                }
                colStart++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Q_59_Spiral_Matrix_II obj = new Q_59_Spiral_Matrix_II();
        System.out.println(Arrays.deepToString(obj.generateMatrix(0)));
        System.out.println(Arrays.deepToString(obj.generateMatrix(1)));
        System.out.println(Arrays.deepToString(obj.generateMatrix(2)));
        System.out.println(Arrays.deepToString(obj.generateMatrix(3)));
        System.out.println(Arrays.deepToString(obj.generateMatrix(4)));
    }
}
