package leet_code.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {



    public int[] nextGreaterElement(int[] nums1, int[] nums2) {   
        Stack<Integer> stack = new Stack();
        HashMap<Integer,Integer> numToGreater = new HashMap();
        stack.push(nums2[0]);
        for(int i = 1; i < nums2.length; i++){
            int top = stack.peek();
            while(top < nums2[i]){
                stack.pop();
                numToGreater.put(top,nums2[i]);
                if(!stack.isEmpty()){
                   top = stack.peek();
                }else{break;}
            }   
            stack.push(nums2[i]);   
        }
        while(!stack.isEmpty()){
            numToGreater.put(stack.pop(),-1);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < ans.length; i++){
            ans[i] = numToGreater.get(nums1[i]);
        }
        return ans;
    }


    public static void main(String[] args){

        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = nextGreaterElementI.nextGreaterElement(nums1, nums2);
        System.out.println("Result: " + Arrays.toString(ans));
        
    }
    
}
