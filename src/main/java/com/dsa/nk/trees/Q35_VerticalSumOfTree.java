package com.dsa.nk.trees;

import java.util.HashMap;
import java.util.Map;

public class Q35_VerticalSumOfTree {

    public static void printVerticalSumOfTree(TreeNode root, Map<Integer, Integer> map, int index ){
        if (root == null){
            map.put(index, map.getOrDefault(index,0)+0);
            return;
        }

        map.put(index, map.getOrDefault(index,0)+ (Integer) root.getData());
        if(root.left != null)
            printVerticalSumOfTree(root.left, map, index-1);

        if (root.right != null)
            printVerticalSumOfTree(root.right, map, index+1);

    }

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        Map<Integer, Integer> map = new HashMap<>();
        printVerticalSumOfTree(treeRoot, map, 0);
//        map.forEach((k,v) -> {
//            System.out.println("Key: " + k +" Value: " + v);
//        });

        map.forEach(Q35_VerticalSumOfTree::print);
    }

    public static void print(Integer k, Integer v){
        System.out.println("Key: " + k +" Value: " + v);
    }
}
