package leet_code.java;

public class  KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for(int pile : piles){
            maxPile = Math.max(maxPile,pile);
        }
        int st = 1;
        int ans = maxPile;
        while(st < maxPile){
            int k = st + (maxPile - st)/2;
            int hrs = 0;
            for(int pile : piles){
                hrs += Math.ceil((double)pile/k); 
            }
            if(hrs <= h){ // decrase k and check 
                ans = k;
                maxPile = k;
                
            }else{ // hrs > h increase k and check 
                st = k + 1;
            }
        }
        return ans;
    }
}
