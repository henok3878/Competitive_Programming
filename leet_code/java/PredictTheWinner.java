package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredictTheWinner {


    public boolean PredictTheWinner(int[] nums) {
        
        Map<String,List<Integer>> dp = new HashMap(); 
        int[] result = play(nums,0,nums.length-1,true,dp);
        return result[0] >= result[1];
        
        
        // board state could be -> st+end
        
    }
    private int[] play(int[] nums,int st, int end,boolean turn, Map<String,List<Integer>> dp){
        if(st == end){
            if(turn){
                return new int[]{nums[st],0};
            }
            else{
                return new int[]{0,nums[st]};
            }
        }
        else{
            if(turn){
                int[] stPicked;
                int[] endPicked;
                if(dp.containsKey((st + 1)+"_"+end)){
                    List<Integer> result = dp.get((st+1)+"_"+end);
                    stPicked = new int[]{result.get(0), result.get(1)};
                    
                }else{
                     stPicked = play(nums,st+1,end,!turn,dp);                
                }
                if(dp.containsKey(st+"_"+(end+1))){
                    List<Integer> result = dp.get(st+"_"+(end+1));
                    endPicked = new int[]{result.get(0), result.get(1)};
                    
                }else{
                      endPicked = play(nums,st,end - 1, !turn,dp);            
                }
            
                stPicked[0] += nums[st];
                endPicked[0] += nums[end];
                
                if(stPicked[0] > endPicked[0]){
                    dp.put(st+"_"+end, new ArrayList(Arrays.asList(stPicked[0],stPicked[1])));
                    return stPicked;
                }
                dp.put(st+"_"+end,new ArrayList(Arrays.asList(endPicked[0],endPicked[1])));
                return endPicked;    
                
            }else{ 
                
                int[] stPicked;
                int[] endPicked;
                if(dp.containsKey((st + 1)+"_"+end)){
                    List<Integer> result = dp.get((st+1)+"_"+end);
                    stPicked = new int[]{result.get(0), result.get(1)};
                    
                }else{
                     stPicked = play(nums,st+1,end,!turn,dp);                
                }
                if(dp.containsKey(st+"_"+(end+1))){
                    List<Integer> result = dp.get(st+"_"+(end+1));
                    endPicked = new int[]{result.get(0), result.get(1)};
                    
                }else{
                      endPicked = play(nums,st,end - 1, !turn,dp);            
                }
            
                stPicked[1] += nums[st];
                endPicked[1] += nums[end];
                
                if(stPicked[1] > endPicked[1]){
                    dp.put(st+"_"+end, new ArrayList(Arrays.asList(stPicked[0],stPicked[1])));
                    return stPicked;
                }
                dp.put(st+"_"+end,new ArrayList(Arrays.asList(endPicked[0],endPicked[1])));
                return endPicked; 
            }
        }
    }



    public static void main(String[] args){

        
    }
    
}
