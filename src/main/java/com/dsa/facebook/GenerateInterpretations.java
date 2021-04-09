package com.dsa.facebook;

public class GenerateInterpretations {


    //TC: 2^N
    //SC: 2^N
    public void generateGraph(String input, int index, GNode root){
        if(index == input.length())
            return;

        int first = Integer.parseInt(input.substring(index, index+1));
        if(first>=1 && first <= 9){
            root.left = new GNode(first);
            generateGraph(input, index+1, root.left);
        }

        if(index+1 < input.length()){
            int second = Integer.parseInt(input.substring(index, index+2));
            if(second>=10 && second <= 26){
                root.right = new GNode(second);
                generateGraph(input, index+2, root.right);
            }
        }
    }

    //TC: O(N)
    //SC : O(1)
    public void printInorder(GNode root, String [] symbols, StringBuilder sb){
        if(root.left == null && root.right == null){
            sb.append(symbols[root.val]);
            if(!sb.toString().isEmpty())
                System.out.println(sb.toString());
            if(sb.length() > 0)
                sb.deleteCharAt(sb.length()-1);
            return;
        }

        sb.append(symbols[root.val]);

        if (root.left != null)
            printInorder(root.left,symbols, sb);

        if (root.right != null)
            printInorder(root.right,symbols, sb);

        if(sb.length() > 0)
            sb.deleteCharAt(sb.length()-1);
    }


    public void generateInterpretations(String input){
        String [] symbols = new String[] {"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        GNode root = new GNode(0);
        generateGraph(input,0, root);
        printInorder(root,symbols,new StringBuilder());
    }

    public static void main(String[] args) {
        String input = "12121";
        GNode root = new GNode(0);

        GenerateInterpretations obj = new GenerateInterpretations();
        obj.generateInterpretations(input);
    }


}

class GNode{
    int val;
    GNode left;
    GNode right;

    public GNode(final int val) {
        this.val = val;
    }
}
