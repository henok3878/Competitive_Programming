package leet_code.java;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];   
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
               int dif = i - coin;
               if(dif == 0) min = 1;
               else if(dif > 0 && amounts[dif] < Integer.MAX_VALUE){
                   min = Math.min(min,amounts[dif] + 1);
               }
            }
           amounts[i] = min;
        }
         
     return (amounts[amount] < Integer.MAX_VALUE) ? amounts[amount] : -1;
         
     }
}
