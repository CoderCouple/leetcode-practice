package com.dsa.nk.trees;

public class Q33_LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2){
        if(root == null)
            return root;

        if(node1 == null || node2 == null)
            return root;

        if(root == node1 || root == node2)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, node1,node2);
        TreeNode right = lowestCommonAncestor(root.right, node1,node2);

        if(left != null && right != null )
            return root;
        else return left == null ? right : left;

    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot1 = TreeNode.getSampleTree();
        System.out.println(lowestCommonAncestor(treeRoot1, treeRoot1.left.left,treeRoot1.right.right).getData());
    }
}
