package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_1522_Diameter_Of_NAry_Tree_II {

    public int diameter(NAryNode root) {
        return diameterOfNaryTree(root).diameter;
    }

    public Diameter diameterOfNaryTree(NAryNode root) {

        if (root.children.size() == 0)
            return new Diameter(0,1);

        int firstMaxHeight = 0;
        int secondMaxHeight = 0;
        int maxDiameter = 0;

        for(NAryNode child: root.children){
            Diameter d = diameterOfNaryTree(child);
            maxDiameter = Math.max(maxDiameter,d.diameter);
            if(d.height>firstMaxHeight){
                secondMaxHeight = firstMaxHeight;
                firstMaxHeight = d.height;
            } else if(d.height>secondMaxHeight){
                secondMaxHeight = d.height;
            }

        }

        int currMaxDiameter = Math.max(maxDiameter,firstMaxHeight+secondMaxHeight);
        return new Diameter(currMaxDiameter,firstMaxHeight+1);
    }

    public static void main(String[] args) {
        NAryNode n1 = new NAryNode(1);
        NAryNode n2 = new NAryNode(2);
        NAryNode n3 = new NAryNode(3);
        NAryNode n4 = new NAryNode(4);
        NAryNode n5 = new NAryNode(5);
        NAryNode n6 = new NAryNode(6);

        n1.children = Arrays.asList(n2,n3,n4);
        n3.children = Arrays.asList(n5,n6);

        Q_1522_Diameter_Of_NAry_Tree_II obj = new Q_1522_Diameter_Of_NAry_Tree_II();
        System.out.println(obj.diameter(n1));
    }
}
class Diameter {
    Integer diameter;
    Integer height;

    public Diameter(Integer diameter, Integer height){
        this.diameter = diameter;
        this.height = height;
    }
}

