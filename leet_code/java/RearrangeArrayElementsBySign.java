package leet_code.java;

import java.util.LinkedList;
import java.util.Queue;

public class  RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        
        Queue<Integer> pos = new LinkedList();
        Queue<Integer> neg = new LinkedList();
        
        int[] ans = new int[nums.length];
        for(int num : nums){
            if(num < 0){
                neg.add(num);
            }else{
                pos.add(num);
            }
        }
        int idx = 0;
        boolean posTurn = true;
        while(!pos.isEmpty() || !neg.isEmpty()){
            int curr;
            if(posTurn && !pos.isEmpty() ){
                curr = pos.poll();
                posTurn = false;
            }
            else{
                curr = neg.poll();
                posTurn = true;
            }
            ans[idx] = curr;
            idx++;
            
        }
        
        return ans;
        
    }
    
}
