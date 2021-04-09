package com.dsa.facebook;

public class Q_1490_Clone_N_Ary_Tree {

    public NAryNode cloneTree(NAryNode root) {
        if(root == null)
            return null;
        NAryNode newRoot = new NAryNode(root.val);

        for(NAryNode child : root.children){
            newRoot.children.add(cloneTree(child));
        }
        return newRoot;
    }
    public static void main(String[] args) {

    }
}
