package leet_code.java;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for(int i = n - 2; i >= 0; i--){
            int t = a; a = a + b; b = t;            
        }
        return a;
    }
}
