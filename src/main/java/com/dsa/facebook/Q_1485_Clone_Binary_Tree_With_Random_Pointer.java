package com.dsa.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q_1485_Clone_Binary_Tree_With_Random_Pointer {

    public NodeRandom copyRandomBinaryTree(NodeRandom root) {
        Map<NodeRandom,NodeRandom> map = new HashMap<>();
        NodeRandom newRoot = copyTree(root,map);
        modifyRandomPointers(root,newRoot,map);
        return newRoot;
    }


    public void modifyRandomPointers(NodeRandom root, NodeRandom newRoot, Map<NodeRandom,NodeRandom> map){
        if(root == null)
            return;

        modifyRandomPointers(root.left, newRoot.left, map);
        newRoot.random = map.getOrDefault(root.random,null);
        modifyRandomPointers(root.right, newRoot.right, map);
    }

    public NodeRandom copyTree(NodeRandom root, Map<NodeRandom,NodeRandom> map){
        if(root == null)
            return null;

        NodeRandom newRoot = new NodeRandom(root.val);
        map.put(root, newRoot);
        newRoot.left = copyTree(root.left, map);
        newRoot.right = copyTree(root.right, map);
        return newRoot;
    }
}