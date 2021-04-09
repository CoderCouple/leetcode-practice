package com.dsa.roku;


/*
There are n nodes in network. They are labeled from 1 to n. Some nodes are connected with each other and some are not.
You are given how long it will take for a signal to reach from one node to another.
We send a signal from a certain node k, how long will it take for all nodes to receive the signal?


public int findDelayTime(int[][] times, int n, int k) {

}

times[i] = (u, v, w)
u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
0





*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Start typing here
class Edge {
    int nodeId;
    int time;

    Edge(int n, int t) {
        nodeId = n;
        time = t;
    }
}
public class DAGTraversal{
    int total_visited_nodes = 0;

    public int findDelayTime(int[][] times, int n, int k){
        // Node -> Edge, Weight
        Map<Integer,List<Edge>> graph = new HashMap<>();
        boolean [] isVisited = new boolean[n+1];

        for(int i = 0; i< n; i++ ){
            graph.put(i, new ArrayList<Edge>());
        }

        for(int [] row : times){
            List<Edge> list = graph.get(row[0]);
            list.add(new Edge(row[1], row[2]));
        }

        int maxDelay =  getDelay(graph, isVisited, k, 0);
        if(total_visited_nodes == n)
            return maxDelay;

        else return -1;

    }



// times[i] = (u, v, w)
// u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
// Output: 2

    //  1  []
    //  2  [1, 1] [3, 1]
    //  3. [4, 1]
    //  4 []


    public int getDelay(Map<Integer,List<Edge>> graph, boolean [] isVisited, int curr, int edgeTime){
        if(curr > graph.size())
            return 0;

        if(isVisited[curr])
            return 0;

        int max = 0;
        isVisited[curr] = true;
        total_visited_nodes += 1;
        for(Edge edge : graph.get(curr)) {
            int delay = getDelay(graph, isVisited, edge.nodeId, edge.time );
            if(delay > max)
                max = delay;
        }
        return max + edgeTime;
    }

}
