package leet_code.java;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        ways[n-1] = 1;
        ways[n] = 1;
        for(int i = ways.length - 3; i >= 0; i--){
            ways[i] = ways[i + 1] + ways[i + 2];
        }
        return ways[0];
    }
}
