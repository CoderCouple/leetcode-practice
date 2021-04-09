package com.dsa.facebook;

public class Q_543_Diameter_Of_Binary_Tree_I {

    // Questions: what will be diameter of a binary tree with only root node
    // Ans : 0 but some people expect it to be 1

    public int diameterOfBinaryTree(TreeNode root) {
        return dbt(root).diameter;
    }

    public Diameter dbt(TreeNode root) {
        if(root == null)
            return new Diameter(0,0);

        Diameter left = dbt(root.left);
        Diameter right = dbt(root.right);
        int currDiameter = Math.max(Math.max(left.diameter,right.diameter), left.height+right.height);
        int currHeight =  Math.max(left.height,right.height)+1;

        return new Diameter(currDiameter,currHeight);
    }

    class Diameter {
        Integer diameter;
        Integer height;

        public Diameter(Integer diameter, Integer height){
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static void main(String[] args) {

    }
}
