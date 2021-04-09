package com.dsa.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingPatterns {

    /*
     * Complete the 'getMinScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts UNWEIGHTED_INTEGER_GRAPH products as parameter.
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static int getMinScore(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        Map<Integer, Set<Integer>> graph = buildGraph(productsNodes, productsFrom, productsTo);

        Integer minScore = null;

        for (int i = 0; i < productsFrom.size(); i++) {
            Integer currentScore = getScoreForCurrentEdge(productsFrom.get(i), productsTo.get(i), graph);

            if (minScore == null || (currentScore != null && currentScore < minScore) ) {
                minScore = currentScore;
            }
        }

        return minScore != null ? minScore : -1;
    }

    private static Integer getScoreForCurrentEdge(int from, int to, Map<Integer, Set<Integer>> graph) {
        Set<Integer> fromNeighbours = graph.get(from);
        Set<Integer> toNeighbours = graph.get(to);

        Integer minEdgeScore = null;

        for (int edge1 : fromNeighbours) {
            if (toNeighbours.contains(edge1)) {
                Set<Integer> trio = new HashSet<>();
                trio.add(from);
                trio.add(to);
                trio.add(edge1);

                int newScore = calculateScoreForCurrentTrio(trio, graph);

                if (minEdgeScore == null || newScore < minEdgeScore) {
                    minEdgeScore = newScore;
                }
            }
        }

        return minEdgeScore;
    }



    private static int calculateScoreForCurrentTrio(Set<Integer> trio, Map<Integer, Set<Integer>> graph) {
        int score = 0;

        for (int node : trio) {
            for (int edge : graph.get(node)) {
                if ( !trio.contains(edge)) {
                    score ++;
                }
            }
        }

        return score;
    }

    private static Map<Integer, Set<Integer>> buildGraph(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= productsNodes; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < productsFrom.size(); i++) {
            int from = productsFrom.get(i);
            int to = productsTo.get(i);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        return graph;
    }

}


