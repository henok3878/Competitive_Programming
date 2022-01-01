package leet_code.java;

import leet_code.java.util.Utility;

public class FindSubsequenceofLengthKWiththeLargestSum {

    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int largestSum = 0;
        for(int i = 0; i <= nums.length-k ; i++){
            int tempSum = 0;
            int[] tempAns = new int[k];
            for(int j = i; j < i+k; j++){
                System.out.println("j-i: " + (j-i) + " j: " + j);
                tempAns[j-i] = nums[j];
                tempSum += nums[j];
                
            }
            if(tempSum > largestSum){
                largestSum = tempSum;
                ans = tempAns;
            }
        }
        return ans;
        
    }

    public static void main(String[] args){
        FindSubsequenceofLengthKWiththeLargestSum findSubsequenceofLengthKWiththeLargestSum = 
        new FindSubsequenceofLengthKWiththeLargestSum();
        int[] nums = {-1,-2,3,4}; int k = 3;
        int[] ans = findSubsequenceofLengthKWiththeLargestSum.maxSubsequence(nums, k);
        Utility.printArray(ans);
    }
    
}
