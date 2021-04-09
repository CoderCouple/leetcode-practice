package com.dsa.leetcode.ch7_OODesign;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dumpLeft(root, stack);
    }

    public int next() {
        if(!stack.isEmpty()){
            TreeNode element = stack.pop();
            if(element.right != null)
                dumpLeft(element.right, stack);

            return element.val;
        }

        return 0;
    }

    public void dumpLeft(TreeNode root, Stack<TreeNode> stack){
        if(root == null)
            return;

        stack.push(root);
        dumpLeft(root.left,stack);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}