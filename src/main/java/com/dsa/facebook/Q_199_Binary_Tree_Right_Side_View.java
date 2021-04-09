package com.dsa.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_199_Binary_Tree_Right_Side_View {

    /*
    Complexity Analysis

    Time complexity: O(N) since one has to visit each node.

    Space complexity: O(D) to keep the queues, where D is a tree diameter.

    Let's use the last level to estimate the queue size.
    This level could contain up to N/2N/2 tree nodes in the case of complete binary tree.
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        TreeNode prev = null;
        TreeNode curr = null;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr != null) {

                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);

            } else {
                if (queue.isEmpty()) {
                    list.add(prev.val);
                    break;
                }
                queue.add(null);
                list.add(prev.val);
            }
            prev = curr;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
