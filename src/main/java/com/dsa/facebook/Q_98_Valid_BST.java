package com.dsa.facebook;

public class Q_98_Valid_BST {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && min >= root.val) || (max != null && max <= root.val))
            return false;

        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }
}

