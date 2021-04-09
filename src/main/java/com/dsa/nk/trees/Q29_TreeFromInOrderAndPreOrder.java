package com.dsa.nk.trees;

public class Q29_TreeFromInOrderAndPreOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0 || preorder.length == 0)
            return null;

        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart , int inEnd) {
        if(preStart>preEnd ||  inStart > inEnd)
            return null;

        int data = preorder[preStart];
        TreeNode<Integer> root = new TreeNode<>(data);
        int offset = inStart;
        for(int i = inStart; i<= inEnd; i++){
            if(inorder[i] == data){
                offset = i;
                break;
            }
        }

        root.left = build(preorder, preStart+1, preStart+offset-inStart, inorder, inStart, offset-1);
        root.right = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    public static void main(String[] args) {

    }
}
