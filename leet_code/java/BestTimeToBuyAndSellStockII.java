package leet_code.java;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int buy = -1;
        for(int i = 0; i < prices.length; i++){
           int left = ((i - 1) >= 0) ? prices[i-1] : Integer.MAX_VALUE;
           int right = ((i + 1) < prices.length) ? prices[i+1] : Integer.MIN_VALUE;
           if(buy == -1 && prices[i] <= left && prices[i] < right) buy = prices[i];
           else if(buy != -1 && prices[i] >= left && prices[i] > right){
                profit += prices[i] - buy; 
                buy = -1;
           }
        }
        return profit;
    }
    
}
