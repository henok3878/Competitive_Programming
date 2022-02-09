package leet_code.java;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        
        int[] dp = new int[prices.length];
        for(int i = 1; i < dp.length; i++) dp[i] = Math.max(dp[i-1], dp[i-1] + (prices[i] - prices[i-1]));
        return dp[prices.length - 1];
     }
    
}
