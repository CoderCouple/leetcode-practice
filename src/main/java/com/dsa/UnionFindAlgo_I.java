package com.dsa;

public class UnionFindAlgo_I {
    public static void main(String[] args) {

        char [][] grid = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};
        Solution s = new Solution();
        s.numIslands(grid);
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int row = grid.length;
        int col = grid[0].length;

        UnionFind uf = new UnionFind(grid);

        for(int r=0; r<row; r++)
            for(int c=0; c<col; c++){
                if(grid[r][c] == '1'){
                    // grid[r][c] = '0';
                    if(r-1>=0 && grid[r-1][c] == '1')
                        uf.union(r*col+c,(r-1)*col+c);

                    if(r+1<row && grid[r+1][c] == '1')
                        uf.union(r*col+c,(r+1)*col+c);

                    if(c-1>=0 && grid[r][c-1] == '1')
                        uf.union(r*col+c,r*col+c-1);

                    if(c+1<col && grid[r][c+1] == '1')
                        uf.union(r*col+c,r*col+c+1);
                }
            }

        return uf.getCount();
    }
}

class UnionFind{
    int count;
    int [] parent;
    int [] rank;

    public UnionFind(char [][] grid) {
        count =0;
        int row = grid.length;
        int col = grid[0].length;

        parent = new int [row * col];
        rank = new int[row * col];

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == '1'){
                    parent[r*col+c] = r*col+c;
                    count++;
                }
                rank[r*col+c] = 0;
            }
        }
    }

    public int getCount(){
        return count;
    }

    public int find(int node){
        if(node != parent[node])
            parent[node] = find(parent[node]); //find with path compression
        return parent[node];
    }

    public void union(int node1, int node2){ //union by rank
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 != root2){
            if(rank[node1] > rank[node2]){
                parent[node2] = node1;
            } else if(rank[node1] < rank[node2]){
                parent[node1] = node2;
            } else {
                parent[node2] = node1;
                rank[node1]= rank[node1]+1;
            }

            count--;
        }

    }
}