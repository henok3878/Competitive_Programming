package leet_code.java;

import java.util.Arrays;
import java.util.Comparator;

import leet_code.java.util.Utility;

public class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return compareLargeIntegers(o2,o1);
            }
        });
        return nums[k-1];
    }

    //Retruns true if num1 is greater, else returns false

    public int compareLargeIntegers(String num1, String num2){

        int num1Size = num1.length();
        int num2Size = num2.length();
        if(num1Size > num2Size){
            return 1;
        }else if(num1Size < num2Size){
            return -1;
        }else{
            return compareLargeIntegersHelper(num1, num2);
        }
    }
    public int compareLargeIntegersHelper(String num1, String num2){
        if(num1.length() == 0){
            return 0;
        }
        char dig1 = num1.charAt(0);
        char dig2 = num2.charAt(0);
        if(dig1 > dig2){
            return 1;
        }else if(dig1 == dig2){
            return compareLargeIntegers(num1.substring(1, num1.length()), num2.substring(1,num1.length()));
        }
        return -1;
    }
    public static void main(String[] args){

        FindTheKthLargestIntegerInTheArray findTheKthLargestIntegerInTheArray = new FindTheKthLargestIntegerInTheArray();
        //String[] nums = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        // int k = 11
        String[] nums = {"52","1","59","57174","5887"};
        int k = 4;
        String result = findTheKthLargestIntegerInTheArray.kthLargestNumber(nums, k);
        System.out.println("Result : " + result);
    }
    
}
