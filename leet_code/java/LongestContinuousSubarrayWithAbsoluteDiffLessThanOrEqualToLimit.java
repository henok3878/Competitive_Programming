package leet_code.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {


    public int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int end = 0;
        int res = 1;
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Comparator.reverseOrder());
       while (start<=end && end<nums.length){
            min.add(nums[end]);
            max.add(nums[end]);
            int minNum = min.peek();
            int maxNum = max.peek();
            if(Math.abs(maxNum-minNum)<=limit){
                end++;
                res=Math.max(res,end-start);
            }else{
                min.remove(nums[start]);
                max.remove(nums[start]);
                end++;
                start++;
            }
        }
        return res;
    }
    
}
