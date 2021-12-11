package leet_code.java;

import java.util.Arrays;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        int[][] kClosest = new int[k][2];
        int[] pointsSortedByDistance = sortPointsBasedOnDistance(points);
        int kthDistance = pointsSortedByDistance[k-1];
        int index = 0;
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int currentDistance = (x*x) + (y*y);
            if(currentDistance <= kthDistance){
                kClosest[index] = points[i];
                index++;
            }

        }
        return kClosest; 
    }
    
    public int[] sortPointsBasedOnDistance(int[][] points){
        //[[x1,y1],[x2,y2],[x3,y3]] sample input 
       int[] distances = new int[points.length];
       for(int i = 0; i < points.length; i++){
           int x = points[i][0];
           int y = points[i][1];
           distances[i] = (x*x) + (y*y);
       }
       Arrays.sort(distances);
       return distances;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        KClosestPoints kClosestPoints = new KClosestPoints();
        kClosestPoints.kClosest(points, k);
        
    }


}
