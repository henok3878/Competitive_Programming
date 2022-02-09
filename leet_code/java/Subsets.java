package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        subsetsHelper(nums,0,nums.length, ans,new ArrayList());
        return ans;
        
    }
    
    private void subsetsHelper(int[] nums, int st, int end,List<List<Integer>> ans,List<Integer> curr ){
        if(st == end){
            ans.add(new ArrayList(curr));
            return;
        }
        // choose start 
        curr.add(nums[st]);
        subsetsHelper(nums,st + 1, end,ans,curr);
        curr.remove(curr.size() - 1);
        subsetsHelper(nums,st + 1, end,ans,curr);
    }
}
