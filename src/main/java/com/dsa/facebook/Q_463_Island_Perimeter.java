package com.dsa.facebook;

public class Q_463_Island_Perimeter {

    //TC: O(m*n) m = row , n= col
    //SC: O(1)
    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        // Traversing the matrix and
        // finding ones to calculate
        // their contribution.
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++)
                if (grid[r][c] == 1)
                    perimeter += (4 -
                            numofneighbour(grid, r, c));

        return perimeter;
    }

     int numofneighbour(int grid[][], int r, int c)
    {

        int neighbours = 0;

        // UP
        if (r > 0 && grid[r - 1][c] == 1)
            neighbours++;

        // DOWN
        if (r < grid.length - 1 && grid[r + 1][c] == 1)
            neighbours++;


        // LEFT
        if (c > 0 && grid[r][c - 1] == 1)
            neighbours++;

        // RIGHT
        if (c < grid[0].length && grid[r][c + 1] == 1)
            neighbours++;

        return neighbours;
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        Q_463_Island_Perimeter obj = new Q_463_Island_Perimeter();
        System.out.println(obj.islandPerimeter(grid));
    }
}
