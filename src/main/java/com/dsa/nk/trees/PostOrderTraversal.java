package com.dsa.nk.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void postOrder(TreeNode root, List<Integer> res){
        if(root != null){
            postOrder(root.getLeft(), res);
            postOrder(root.getRight(), res);
            //System.out.print(root.getData()+"\t");
            res.add((Integer) root.getData());
        }
    }

    public static void main(String[] args) {

        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        List<Integer> res = new ArrayList<>();
        postOrder(treeRoot,res);
        System.out.println(res);
        res = postOrderIterative(treeRoot);
        System.out.println(res);
        System.out.println(postOrderIterative(treeRoot).equals(res));
    }

    public static List<Integer> postOrderIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode<Integer>> s1 = new Stack<>();
        Stack<TreeNode<Integer>> s2 = new Stack<>();

        if(root == null)
            return result;

        s1.add(root);
        while (!s1.isEmpty()){
         TreeNode curr = s1.pop();
         s2.push(curr);
         if(curr.getLeft() != null)
             s1.push(curr.getLeft());

         if(curr.getRight() != null)
             s1.push(curr.getRight());
         }

        s2.forEach(node -> result.add(node.getData()));
        return result;

    }
}
