package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        combinationSumHelper(candidates,ans, new ArrayList(),target,0);
        return ans;
    }
    
    
    private void combinationSumHelper(int[] candidates, List<List<Integer>> ans, 
                                     List<Integer> resSofar,int target, int idx){
        if(target == 0){
            ans.add(new ArrayList(resSofar));
            
        }
        else if(target < 0){
            return;
        }
        else{
            for(int i = idx; i < candidates.length ; i++){
                resSofar.add(candidates[i]);
                combinationSumHelper(candidates,ans,resSofar,target - candidates[i], i);
                resSofar.remove(resSofar.size() - 1);
            }
        }
    }
}
