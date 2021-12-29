package leet_code.java;

public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {
        
        int totalMove = 0;
        int[] count = new int[100001];
        for(int i =0 ; i < nums.length; i++){
            count[nums[i]]++; 
        }
        //System.out.println("c: " + Arrays.toString(count));

        for(int i = 1; i < count.length; i++){
            if(count[i-1] < 2){
                continue;
            }
            totalMove += count[i-1] - 1;
            count[i] += count[i-1] - 1;
            //System.out.println("TotalMove: " + totalMove);

        }
        //System.out.println("c: " + Arrays.toString(count));
        int finalDigOcc = count[count.length -1 ] - 1;
        totalMove += ((finalDigOcc + 1)*finalDigOcc)/2;
        //System.out.println("final: " + (finalDigOcc + 1)/2*finalDigOcc);
        //System.out.println("TotalMove: " + totalMove);
        return totalMove;
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,2,1,7};
        MinimumIncrementToMakeArrayUnique minimumIncrementToMakeArrayUnique = new MinimumIncrementToMakeArrayUnique();
        int result = minimumIncrementToMakeArrayUnique.minIncrementForUnique(nums);
        
        System.out.println("Ans: " + result);
    }
    
}
