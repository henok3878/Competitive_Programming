package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int idx1 = 0;
        Arrays.sort(nums);
        while(idx1 < nums.length && nums[idx1] <= 0){
            int left = 0 - nums[idx1];
            int idx2 = idx1 + 1;
            while(idx2 < nums.length){
                int compl = left - nums[idx2];
                int idx3 = findNum(nums,idx2+1,compl); 
                if(idx3 != -1){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[idx1]);
                    temp.add(nums[idx2]);
                    temp.add(nums[idx3]);
                    ans.add(temp);
                    while((idx2 + 1) < nums.length && nums[idx2] == nums[idx2 + 1]) idx2++;
                }
                idx2++;
            }
            while((idx1 + 1) < nums.length && nums[idx1] == nums[idx1 + 1]) idx1++;
            idx1++;
        }
        return ans;
    }
    
    
    
    private int findNum(int[] nums, int st, int num){
        int stIdx = st, endIdx = nums.length-1;
        while(stIdx <= endIdx){
            int mid = (stIdx + endIdx) / 2;
            if(nums[mid] > num){
                endIdx = mid - 1;
            }else if(nums[mid] < num){
                stIdx = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
