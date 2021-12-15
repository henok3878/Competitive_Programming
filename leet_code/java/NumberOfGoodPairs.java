package leet_code.java;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int[] occuranceCount = new int[101];

        for(int i = 0; i < nums.length; i++){

            occuranceCount[nums[i]] = occuranceCount[nums[i]] + 1;
        }

        int accum = 0;
        for(int i = 0; i < occuranceCount.length; i++){
            int n = occuranceCount[i] - 1;
            accum += n*(n+1)/2;

        }
        return accum;   
        
    }


    public static void main(String[] args){

    }    
}
