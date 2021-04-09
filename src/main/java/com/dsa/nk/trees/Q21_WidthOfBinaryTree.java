package com.dsa.nk.trees;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q21_WidthOfBinaryTree {

    public static void getWidth(TreeNode root, int depth, Map<Integer,Integer> map){
        if(root == null)
            return;

        map.put(depth, map.getOrDefault(depth,0)+1);
        getWidth(root.getLeft(), depth+1, map);
        getWidth(root.getRight(), depth+1, map);
    }

    public static void main(String[] args) {

        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        Map<Integer,Integer> map = new HashMap<>();
        getWidth(treeRoot,0,map);
        System.out.println(new ArrayList<>(map.values()).stream().max(Comparator.naturalOrder()).get());
    }
}
