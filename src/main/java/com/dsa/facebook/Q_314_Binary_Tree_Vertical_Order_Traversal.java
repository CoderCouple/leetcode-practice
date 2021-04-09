package com.dsa.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


/*
*
* Time Complexity: O(NlogN) where N is the number of nodes in the tree.

In the first part of the algorithm, we do the BFS traversal, whose time complexity is \mathcal{O}(N)O(N) since we traversed each node once and only once.

In the second part, in order to return the ordered results, we then sort the obtained hash table by its keys, which could result in the \mathcal{O}(N \log N)O(NlogN) time complexity in the worst case scenario where the binary tree is extremely imbalanced (for instance, each node has only left child node.)

As a result, the overall time complexity of the algorithm would be \mathcal{O}(N \log N)O(NlogN).

Space Complexity: O(N) where NN is the number of nodes in the tree.

First of all, we use a hash table to group the nodes with the same column index. The hash table consists of keys and values. In any case, the values would consume \mathcal{O}(N)O(N) memory. While the space for the keys could vary, in the worst case, each node has a unique column index, i.e. there would be as many keys as the values. Hence, the total space complexity for the hash table would still be \mathcal{O}(N)O(N).

During the BFS traversal, we use a queue data structure to keep track of the next nodes to visit. At any given moment, the queue would hold no more two levels of nodes. For a binary tree, the maximum number of nodes at a level would be \frac{N+1}{2}
2
N+1
  which is also the number of leafs in a full binary tree. As a result, in the worst case, our queue would consume at most \mathcal{O}(\frac{N+1}{2} \cdot 2) = \mathcal{O}(N)O(
2
N+1
 ⋅2)=O(N) space.

Lastly, we also need some space to hold the results, which is basically a reordered hash table of size \mathcal{O}(N)O(N) as we discussed before.

To sum up, the overall space complexity of our algorithm would be \mathcal{O}(N)O(N).
* */
public class Q_314_Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Map<Integer,List<Integer>> map = new TreeMap<>();
        Queue<NodePair> queue = new LinkedList<NodePair>();
        queue.add(new NodePair(root,0));

        while(!queue.isEmpty()){
            NodePair curr = queue.poll();
            if(!map.containsKey(curr.level)){
                map.put(curr.level, new ArrayList<>());
            }
            map.get(curr.level).add(curr.node.val);

            if(curr.node.left != null)
                queue.add(new NodePair(curr.node.left, curr.level-1));

            if(curr.node.right != null)
                queue.add(new NodePair(curr.node.right, curr.level+1));
        }

        result.addAll(map.values());
        return  result;

    }
}

class NodePair{
    TreeNode node;
    int level;

    public NodePair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}