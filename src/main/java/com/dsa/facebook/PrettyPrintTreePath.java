package com.dsa.facebook;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class PrettyPrintTreePath {

    public static void printTreePath(TreeNodeString root){
        if(root == null)
            return;

        List<Pair<TreeNodeString,Integer>> path = new ArrayList<>();
        Integer min = new Integer(0);
        prettyPrint(root, 0, path,min);
    }

    public static void prettyPrint(TreeNodeString root, int position, List<Pair<TreeNodeString,Integer>> path, Integer minLeft){
        if(root.left == null && root.right == null){
            Pair<TreeNodeString,Integer> pair = Pair.of(root,position);
            path.add(pair);
            if(minLeft>position)
                minLeft = new Integer(position);
            printTreePath(path, minLeft);
            path.remove(pair);
        }

        Pair<TreeNodeString,Integer> pair = Pair.of(root,position);
        if(minLeft>position)
            minLeft = new Integer(position);

        if(root.left != null){
            path.add(pair);
            prettyPrint(root.left, position-1, path, minLeft);
            path.remove(pair);
        }

        if(root.right != null){
            path.add(pair);
            prettyPrint(root.right, position+1, path, minLeft);
            path.remove(pair);
        }

    }

    public static void printTreePath(List<Pair<TreeNodeString,Integer>> path, int minLeft){
        for(Pair<TreeNodeString,Integer> pair : path){
            int indentation = Math.abs(minLeft)+ pair.getRight();
            for(int i=0; i<=indentation;i++){
                System.out.print(" ");
            }
            System.out.print(pair.getLeft().val);
            System.out.println("");
        }
        System.out.println("==========");
    }

    public static void main(String[] args) {
        TreeNodeString A = new TreeNodeString("A");
        TreeNodeString B = new TreeNodeString("B");
        TreeNodeString C = new TreeNodeString("C");
        TreeNodeString D = new TreeNodeString("D");
        TreeNodeString E = new TreeNodeString("E");
        TreeNodeString F = new TreeNodeString("F");

        A.left = B;
        A.right = C;

        B.left = D;

        C.left = E;
        C.right = F;

        printTreePath(A);
    }
}

class TreeNodeString {
    String val;
    TreeNodeString left;
    TreeNodeString right;

    TreeNodeString() {
    }

    TreeNodeString(String val) {
        this.val = val;
    }

    TreeNodeString(String val, TreeNodeString left, TreeNodeString right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



