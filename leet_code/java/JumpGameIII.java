package leet_code.java;

import java.util.HashSet;
import java.util.Set;

public class JumpGameIII {

    boolean canReach(int[] arr, int start){
        Set<Integer> alreadyVisited = new HashSet<>();
        return canReachHelper(arr, start, alreadyVisited);
    }

                    

        boolean canReachHelper(int[] arr, int index, Set<Integer> alreadyVisited){
            if(index < 0 || index >= arr.length){
                return false;
            }
            else if(arr[index] == 0){
                return true;
            }
            else{
                int nextJump1 = index + arr[index];
                int nextJump2 = index - arr[index];
                if(alreadyVisited.contains(nextJump1)){
                    return false;
                }
                boolean firstJumpResult = canReachHelper(arr, nextJump1,alreadyVisited);
                alreadyVisited.add(nextJump1);
                if(!firstJumpResult){
                    if(alreadyVisited.contains(nextJump2)){
                        return false;
                    }
                    boolean secondJumpResult = canReachHelper(arr, nextJump2,alreadyVisited);
                    alreadyVisited.add(nextJump2);
                    return secondJumpResult;
                }else{
                    return true;
                } 
        }
    }




    public static void main(String[] args){

        int[] arr = {3,0,2,1,2};
        int start = 2;
        JumpGameIII jumpGameIII = new JumpGameIII();
        System.out.println(jumpGameIII.canReach(arr, start));

    }
    
}
