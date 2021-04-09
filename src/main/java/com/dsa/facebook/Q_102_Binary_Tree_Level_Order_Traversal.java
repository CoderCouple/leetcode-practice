package com.dsa.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Q_102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            if(node != null){
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);

            } else{
                if(queue.isEmpty()){
                    result.add(list);
                    break;
                }
                result.add(list);
                list = new ArrayList<Integer>();
                queue.add(null);
            }
        }

        return result;
    }
}