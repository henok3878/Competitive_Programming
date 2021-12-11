package leet_code.java;

public class JumpGameIII {

    boolean canReach(int[] arr, int start){
        if(start < 0 || start >= arr.length){
            return false;
        }
        else if(arr[start] == 0){
            return true;
        }
        else{
            int nextJump1 = start + arr[start];
            int nextJump2 = start - arr[start];

            boolean firstJumpResult = canReach(arr, nextJump1);
            boolean secondJumpResult = canReach(arr, nextJump2);
            if(nextJump1 < 0 || nextJump1 >= arr.length){
                    firstJumpResult = false;
            }else if(nextJump2 < 0 || nextJump2 >= arr.length){
                secondJumpResult = false;
            }
            return firstJumpResult || secondJumpResult;
        }
    }



    public static void main(String[] args){

        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        JumpGameIII jumpGameIII = new JumpGameIII();
        System.out.println(jumpGameIII.canReach(arr, start));

    }
    
}
