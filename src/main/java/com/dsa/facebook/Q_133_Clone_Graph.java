package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q_133_Clone_Graph {

    public  static GraphNode cloneGraph(GraphNode node) {
        Map<GraphNode,GraphNode> isVisited = new HashMap<GraphNode,GraphNode>();
        return graphCloneHelper(node,isVisited);
    }

    public static GraphNode graphCloneHelper(GraphNode node, Map<GraphNode,GraphNode> isVisited) {
        if( node == null)
            return node;

        if(isVisited.containsKey(node))
            return isVisited.get(node);

        GraphNode newNode = new GraphNode(node.val, new ArrayList<GraphNode>());
        isVisited.put(node, newNode);

        for(GraphNode n : node.neighbors){
            newNode.neighbors.add(graphCloneHelper(n,isVisited));
        }

        return newNode;
    }

    public static void printGraph(GraphNode node, Set<GraphNode> isVisited) {
        if( node == null)
            return;

        if(isVisited.contains(node))
            return;

        isVisited.add(node);
        System.out.print("Node : "+node.val+" Node Neighbors : "+node.neighbors);
        System.out.println(" ");
        for(GraphNode n : node.neighbors) {
            printGraph(n, isVisited);
        }
    }

    public static void main(String[] args) {
        GraphNode n1= new GraphNode(1);
        GraphNode n2= new GraphNode(2);
        GraphNode n3= new GraphNode(3);
        GraphNode n4= new GraphNode(4);

        n1.neighbors = Arrays.asList(n2,n4);
        n2.neighbors = Arrays.asList(n1,n3);
        n3.neighbors = Arrays.asList(n2,n4);
        n4.neighbors = Arrays.asList(n1,n3);

        Set<GraphNode> isVisited = new HashSet<>();
        printGraph(n1,isVisited);

    }
}
