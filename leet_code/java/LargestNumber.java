package leet_code.java;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings,new Comparator<String>() {
            public int compare(String o1, String o2) {
                String conct1 = o1 + o2;
                String conct2 = o2 + o1;
                return conct2.compareTo(conct1);
            }
        });
        if(strings[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strings){
            sb.append(s);
        }
        return sb.toString();
        
    }

    public static void main(String[] args){
        LargestNumber largestNumber = new LargestNumber();
        //int[] nums =  {3,30,34,5,9};
        int[] nums =  {0,0};
        String largestNum = largestNumber.largestNumber(nums);
        System.out.println(largestNum);
    }

    
}
