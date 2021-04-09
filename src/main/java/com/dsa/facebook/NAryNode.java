package com.dsa.facebook;

import java.util.ArrayList;
import java.util.List;

class NAryNode {
    public int val;
    public List<NAryNode> children;


    public NAryNode() {
        this.children = new ArrayList<NAryNode>();
    }

    public NAryNode(int val) {
        this.val = val;
        this.children = new ArrayList<NAryNode>();
    }

    public NAryNode(int val, ArrayList<NAryNode> children) {
        this.val = val;
        this.children = children;
    }
}
