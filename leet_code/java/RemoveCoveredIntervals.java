package leet_code.java;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        int left = intervals[0][0], right = intervals[0][1], ans = 1;
        for(int[] interval : intervals){
           if(interval[0] <= left){
               left = interval[0]; 
               right = Math.max(right,interval[1]);
           }else if(interval[1] > right){
               left = interval[0]; right = interval[1];
               ans++;
           }
        }
        return ans;  
    }
}
