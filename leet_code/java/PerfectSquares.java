package leet_code.java;

public class PerfectSquares {
    public int numSquares(int n) {
        int size = (int) Math.sqrt(n);
        int[] perfectSquars = new int[size];
        int[] dp = new int[n+1];
        
        for(int i = 1; i <= size; i++){
            perfectSquars[i-1] = (i * i);
        }
        //System.out.println(Arrays.toString(perfectSquars));
        for(int i = 1; i <= n; i++){
            int min = -1;
            for(int sq : perfectSquars){
                int dif = (i - sq);
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
