package com.dsa.facebook;

import java.util.HashSet;
import java.util.Set;

public class Q_785_Is_Graph_Bipartite {

    /*

      Time Complexity: O(N + E), where N is the number of nodes in the graph, and E is the number of edges.
      We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.

      Space Complexity: O(N), the space used to store the color.
    * */

    public boolean isBipartite(int[][] graph) {
        Set<Integer> currSet = new HashSet<>();
        Set<Integer> otherSet = new HashSet<>();

        for (int node = 0; node < graph.length; node++) {
            if (currSet.contains(node) || otherSet.contains(node))
                continue;

            currSet.add(node);

            if (!isBipartiteHelper(graph, node, currSet, otherSet)) {
                return false;
            }
        }
        return true;
    }


    public boolean isBipartiteHelper(int[][] graph, int root, Set<Integer> currSet, Set<Integer> otherSet) {

        int[] neighbours = graph[root];

        for (int neighbour : neighbours) {
            if (!currSet.contains(neighbour) && !otherSet.contains(neighbour)) {  //isVisited check

                otherSet.add(neighbour);
                if (!isBipartiteHelper(graph, neighbour, otherSet, currSet))
                    return false;

            } else {
                if (currSet.contains(neighbour))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}; // false
        int[][] graph2 = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}; // true


        Q_785_Is_Graph_Bipartite obj = new Q_785_Is_Graph_Bipartite();
        System.out.println(obj.isBipartite(graph1));
        System.out.println(obj.isBipartite(graph2));
    }
}
