package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q_54_Spiral_Matrix {

    // TC: O(n) n: number of elements in the matrix
    // SC: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List result = new ArrayList();

        if (matrix.length == 0)
            return result;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int col = colStart; col <= colEnd; col++) {
                    result.add(matrix[rowStart][col]);
                }
                rowStart++;
            }
            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int row = rowStart; row <= rowEnd; row++) {
                    result.add(matrix[row][colEnd]);
                }
                colEnd--;
            }

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    result.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }

            if (colStart <= colEnd && rowStart <= rowEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    result.add(matrix[row][colStart]);
                }
                colStart++;
            }

        }

        return result;
    }

    public static void main(String[] args) {

        Q_54_Spiral_Matrix obj = new Q_54_Spiral_Matrix();
        int[][] matrix1 = new int[0][0];
        int[][] matrix2 = {{1}};
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix5 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 1, 12}, {13, 14, 15, 16}};

        System.out.println(obj.spiralOrder(matrix1));
        System.out.println(obj.spiralOrder(matrix2));
        System.out.println(obj.spiralOrder(matrix3));
        System.out.println(obj.spiralOrder(matrix4));
        System.out.println(obj.spiralOrder(matrix5));

    }
}
