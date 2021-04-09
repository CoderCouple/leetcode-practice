package com.dsa.roku;

import com.dsa.facebook.TreeNode;
import org.apache.commons.lang3.tuple.Pair;

public class UniversalValueTree {
}

/* unival tree: tree where all nodes have some value

   1
1.   1

    1
     1
       2
*/

//TC: O(n)
class Solution{
    public boolean isUnival(TreeNode root){
        Integer globalUnivalCont =0;
        if(root == null)
            return true;

        return isUnivalRecursive(root, root.val) ;

    }

    public boolean isUnivalRecursive(TreeNode root, int currVal) {
        // Could be leaf node
        if(root == null)
            return true;
        if(root.val != currVal)
            return false;

        return isUnivalRecursive(root.left, currVal) && isUnivalRecursive(root.right, currVal);
    }

    /* unival subtree: subtree where all its children have the same value
        1
       1 1

       >> 3

         1
           1
             2

       >> 1

    */
//    public Pair<Boolean, Integer> getUnivalCount(TreeNode root, globalUnivalCont){
//
//        if(root.left != null){
//            Pair<Boolean, Integer> left = getUnivalCount(root.left, root.val);
//        }
//
//
//        if(root.right != null)
//            Pair<Boolean, Integer> right = getUnivalCount(root.right, globalUnivalCont);
//
//
//        if(left.getLeft() && right.getLeft())
//            if(root.val == left.val && root.val == right.val)
//                return left.getRight() + right.getright() + 1;
//            else left.getRight() + right.getright();
//
//    }
}

