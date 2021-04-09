package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q_257_All_Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null)
            return list;
        binaryTreePathsHelper(root,new StringBuilder(), list);
        return list;
    }

    public void binaryTreePathsHelper(TreeNode root, StringBuilder sb, List<String> list) {
        if(root.left == null && root.right == null){
            if(sb.length() == 0){
                sb.append(root.val);
            } else {
                sb.append("->").append(root.val);
            }
            list.add(sb.toString());
            return;
        }

        if(sb.length() == 0){
            sb.append(root.val);
        } else {
            sb.append("->").append(root.val);
        }

        if(root.left != null)
            binaryTreePathsHelper(root.left,new StringBuilder(sb.toString()),list);
        if(root.right != null)
            binaryTreePathsHelper(root.right,new StringBuilder(sb.toString()),list);
    }

    public static void main(String[] args) {

        //      1
        //     / \
        //    2   3
        //   /   / \
        //  4   5   6

        Q_257_All_Binary_Tree_Paths obj = new Q_257_All_Binary_Tree_Paths();

        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);

        A.left = B;
        A.right = C;

        B.left = D;

        C.left = E;
        C.right = F;

        System.out.println(obj.binaryTreePaths(A));
    }
}
