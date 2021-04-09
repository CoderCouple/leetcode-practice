package com.dsa.facebook;

public class BinaryTreeToggleLeafValueAndUpdateWholeTree {

    public static void main(String[] args) {

    }

    //TC: O(n)
    //SC: O(1)
    // Avg Time Complexity : O(1)

    /*
    One interesting follow-up is asking the "<b>Average Time Complexity</b>" of the program.

    Firstly, lets check what's the possibility of changing the next parent for any node.
    If current node is 1, the parent is 0, the other child should be 0, so if we flip the current node from 1 to 0, the parent value doesn't need to change;
    If parent is 1, the parent should definitely be changed to 0; If current node is 0, the parent is 0, the other child would be 0 or 1, so if we flip the current node, we have half-half chance to change the parent.
    Now we have this chart:

    Current	Sibling	Change or Not
    1	0	N
    1	1	Y
    0	0	N
    0	1	Y
    Our conclusion is that we have 50% possibility to change any node's parent node(as long as it has parent).

    Now let's calculate the Average time complexity. When the program starts to update the tree from bottom up, the possibility to change the first node's value is 1.
    The possibility to change the parent of the first node is 1/2. But changing the grandparent of the first node will become 1/2 * 1/2.
    So if the tree contains N nodes, the hight is Log(N), the possibility to change the root is (1/2)^(log(N) - 1).
    So we have the Expectation of time complexity: E(t) = 1 + 1/2 + 1/2*1/2 + (1/2)^3 + ... + (1/2)^ (log(N) -1).
    If N is positive infinity, the E(t) is approaching 2.
    When N is a normal positive number, E(t) will be always less than 2. So the <b>Average Time Complexity is O(2) (i.e., O(1))</b>.
    * */
    public void toggleTree(BinaryNode node){
        if(node == null)
            return;

        node.val= node.val == 0 ? 1: 0;
        BinaryNode curr = node;
        while(curr.parent != null){
            curr = curr.parent;
            int val = curr.val;
            if(val == (curr.left.val & curr.right.val))
                break;
        }
    }
}

class BinaryNode{
    int val;
    BinaryNode left;
    BinaryNode right;
    BinaryNode parent;

    public BinaryNode(final int val) {
        this.val = val;
    }
}
