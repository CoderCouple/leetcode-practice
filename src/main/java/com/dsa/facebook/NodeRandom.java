package com.dsa.facebook;

public class NodeRandom {
    int val;
    NodeRandom left;
    NodeRandom right;
    NodeRandom random;
    NodeRandom() {}
    NodeRandom(int val) { this.val = val; }
    NodeRandom(int val, NodeRandom left, NodeRandom right, NodeRandom random) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.random = random;
      }
}
