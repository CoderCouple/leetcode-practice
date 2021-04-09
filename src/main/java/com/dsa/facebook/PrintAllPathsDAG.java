package com.dsa.facebook;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllPathsDAG {

    public List<List<Integer>> printAllPathDAG(int[][] graph) {
        Set<Integer> isVisited = new HashSet<>();
        List<List<Integer>> paths = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(!isVisited.contains(i)){
                List<Integer> path = new ArrayList<>();
                allPathHelper(graph,i,path,paths, isVisited);
            }
        }
        return paths;
    }

    public void allPathHelper(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths, Set<Integer> isVisited) {
        if(isVisited.contains(node) || graph[node].length ==0 ){
            path.add(node);
            isVisited.add(node);
            paths.add(path);
            return;
        }

        // Mark it as visited
        path.add(node);
        isVisited.add(node);
        for(int neighbour : graph[node]){
            allPathHelper(graph,neighbour, new ArrayList<>(path), paths, isVisited);
        }

    }
    public static void main(String[] args) {
        PrintAllPathsDAG obj = new PrintAllPathsDAG();
        int [][] input1 = new int [][]{{4,3,1},{3,2,4},{3},{4},{},{6},{}};
        List<List<Integer>> res = obj.printAllPathDAG(input1);
        for(List<Integer> list : res)
            System.out.println(list);

    }
}
