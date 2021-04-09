package com.dsa.nk.trees;

class MyInt {
    int i;
    MyInt(int i) {
        this.i = i;
    }
}
public class Q20_DiameterOfBinaryTree {

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

    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = TreeNode.getSampleTree();
        Q20_DiameterOfBinaryTree obj = new Q20_DiameterOfBinaryTree();
        Integer result = obj.diameterOfBinaryTree(treeRoot);
        System.out.println(result);
    }

    class Diameter {
        Integer diameter;
        Integer height;

        public Diameter(Integer diameter, Integer height){
            this.diameter = diameter;
            this.height = height;
        }
    }
}
