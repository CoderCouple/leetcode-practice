package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class K_Nearest_Point {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(Comparator.comparing(Point::getDistance,Comparator.reverseOrder()));
        List<Point> pointList = new ArrayList<>();
        Arrays.stream(points).forEach(x -> pointList.add(new Point(x[0],x[1])));
        for(Point p : pointList){
            if(maxHeap.size()>=K){
                maxHeap.offer(p);
                maxHeap.poll();
            } else {
                maxHeap.offer(p);
            }
        }
        int [][] result = new int [K][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Point p = maxHeap.poll();
            result[index][0] = p.x;
            result[index][1] = p.y;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        K_Nearest_Point obj = new K_Nearest_Point();
        int [][] points1 = new int[][]{{1,3},{-2,2}};

        System.out.println(Arrays.deepToString(obj.kClosest(points1,1)));


        int [][] points2 = new int[][]{{3,3},{5,-1},{-2,4}};
        System.out.println(Arrays.deepToString(obj.kClosest(points2,2)));
    }
}

class Point{
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // No need for square root
    public double getDistance(){
        return Math.sqrt((this.x*this.x)+(this.y*this.y));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}