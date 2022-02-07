package leet_code.java;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            int min = -1;
            for(int sq = 1;(sq * sq) <= i; sq++){
                int dif = (i - (sq*sq));
                if(dif == 0) min = 1;
                else if(dif > 0 && dp[dif] != -1){
                    min = (min == -1) ? dp[dif] + 1 : Math.min(min,dp[dif] + 1);
                }
            }
            dp[i] = min;
            
        }      
        return dp[n];
    }
}
