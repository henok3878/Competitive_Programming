package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numbers = new ArrayList();
        for(int num : nums){numbers.add(num);}
        List<List<Integer>> ans = new ArrayList();
        permuteHelper(numbers,ans,new ArrayList());
        return ans;
    }
    
    
    private void permuteHelper(List<Integer> nums, List<List<Integer>> ans,
                            List<Integer> resSofar){        
        if(nums.size() == 0){
             ans.add(new ArrayList(resSofar));
        }
        else{
            for(int i = 0; i < nums.size(); i++){
                int curr = nums.get(i);
                resSofar.add(curr);
                nums.remove(i);
                permuteHelper(nums,ans,resSofar);
                resSofar.remove(resSofar.size() - 1);
                nums.add(i,curr);
            }
        }
        
        
    }
}
