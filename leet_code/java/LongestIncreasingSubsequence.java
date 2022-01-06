package leet_code.java;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }   
        int max = 0;
        int[] longest = new int[nums.length];
        longest[nums.length- 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
           int maxAtI = 1;
           for(int j = i + 1;j < nums.length ;j ++){
               if(nums[i] < nums[j]){
                   maxAtI = Math.max(maxAtI, 1 + longest[j]);
               }
           }
           longest[i] = maxAtI;  
           if(max < maxAtI){
               max = maxAtI;
           }
        }
        return max;
           
       }

       public static void main(String[] args){
           int[] nums = {10,9,2,5,3,7,101,18};
           LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
           int res = longestIncreasingSubsequence.lengthOfLIS(nums);
           System.out.println("Res: " + res);
       }
    
}
