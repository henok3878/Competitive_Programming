package leet_code.java;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int myPicker = piles.length- 2;
        int numOfRound = (piles.length)/3;
        int totalCoins = 0;
        while(numOfRound > 0){
            totalCoins += piles[myPicker];
            myPicker -= 2;
            numOfRound--;
        }        
        return totalCoins;
        
    }

    public static void main(String[] args){

        MaximumNumberOfCoinsYouCanGet maximumNumberOfCoinsYouCanGet = new MaximumNumberOfCoinsYouCanGet();
        int[] piles = {2,4,1,2,7,8};
        int totalCoins = maximumNumberOfCoinsYouCanGet.maxCoins(piles);
        System.out.println("Total coins: " + totalCoins);
    }
    
}
