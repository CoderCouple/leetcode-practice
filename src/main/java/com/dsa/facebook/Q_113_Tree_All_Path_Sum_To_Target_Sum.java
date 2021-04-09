package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q_113_Tree_All_Path_Sum_To_Target_Sum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        pathSum(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    public void pathSum(TreeNode root, int target, int curr, List<Integer> list, List<List<Integer>> result) {

        if(root.left == null && root.right == null){
            curr = curr + root.val;
            if(curr == target){
                list.add(root.val);
                result.add(list);
            }
            return;
        }

        list.add(root.val);
        curr = curr + root.val;

        if(root.left != null){
            List<Integer> leftList = new ArrayList<>(list);
            pathSum(root.left, target, curr, leftList, result);
        }


        if(root.right != null){
            List<Integer> rightList = new ArrayList<>(list);
            pathSum(root.right, target, curr, rightList, result);
        }
    }
    public static void main(String[] args) {

    }
}
