package com.dsa.nk.trees;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode<T> {
    T data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(final T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(final T data, final TreeNode left, final TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(final TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(final TreeNode right) {
        this.right = right;
    }

    public void setLeftAndRight(TreeNode left, TreeNode right){
        this.setLeft(left);
        this.setRight(right);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof TreeNode)) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        return new EqualsBuilder()
                .append(data, treeNode.data)
                .append(left, treeNode.left)
                .append(right, treeNode.right)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(data)
                .append(left)
                .append(right)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("data", data)
                .append("left", left)
                .append("right", right)
                .toString();
    }

    public static List<Integer> levelOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            TreeNode<Integer> curr =  queue.poll();
            if(curr != null){
                System.out.print(curr.getData()+" ");
                result.add(curr.getData());
                if(curr.getLeft() != null)
                    queue.add(curr.getLeft());
                if(curr.getRight() != null)
                    queue.add(curr.getRight());
            }
            else if(queue.isEmpty())
                break;
            else {
                queue.add(null);
                result.add(null);
                System.out.println("");
            }
        }
        return result;
    }

    public static TreeNode<Integer> getSampleTree(){

        /*
         *             Visual Representation of The Tree
         *                           7
         *                         /   \
         *                       1      9
         *                     /  \    / |
         *                    0    3  8  10
         *                       /  \
         *                      2    5
         *                          / \
         *                         4   6
         * */

        TreeNode<Integer> node0 = new TreeNode<>(0);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        TreeNode<Integer> node10 = new TreeNode<>(10);

        node7.setLeftAndRight(node1,node9);
        node1.setLeftAndRight(node0,node3);
        node3.setLeftAndRight(node2,node5);
        node5.setLeftAndRight(node4,node6);
        node9.setLeftAndRight(node8,node10);

        return node7;
    }
}
