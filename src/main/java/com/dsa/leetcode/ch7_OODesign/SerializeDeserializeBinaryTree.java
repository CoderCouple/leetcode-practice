package com.dsa.leetcode.ch7_OODesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {
        Codec c = new Codec();
        //System.out.println(c.deserialize(c.serialize(null)));
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;

        String s = c.serialize(n1);
        c.deserialize(s);

    }
}

class Codec {

        // Encodes PowerOfTwo tree to PowerOfTwo single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root,sb);
            return sb.toString();
        }

        public void serializeHelper(TreeNode root, StringBuilder sb){
            if(root == null){
                sb.append("null").append(",");
                return;
            }

            sb.append(root.val).append(",");
            serializeHelper(root.left,sb);
            serializeHelper(root.right,sb);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.isEmpty())
                return null;

            String [] dataArray = data.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(dataArray));
            Iterator<String> it = list.iterator();
            return deserializeHelper(it);
        }

        public TreeNode deserializeHelper(Iterator<String> it) {
            if (!it.hasNext())
                return null;

            String element = it.next();
            if (element.equals("null")) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(element));
            root.left = deserializeHelper(it);
            root.right = deserializeHelper(it);

            return root;
        }
}