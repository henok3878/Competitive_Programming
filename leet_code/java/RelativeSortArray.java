package leet_code.java;

import leet_code.java.util.Utility;

public class RelativeSortArray {



    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        boolean[] occuranceCount1 = new boolean[arr2.length];
        for(int i = 0; i < arr2.length ; i++){
            occuranceCount1[arr2[i]] = true;
        }
        int[] occuranceCount = new int[20]; 
        for(int i = 0; i < n1 ; i++){
            int step = 1;
            if(!occuranceCount1[arr2[i]]){
                step = n2;
            }
            occuranceCount[arr2[i]] = occuranceCount[arr1[i]] + step;
        }
        Utility.printArray(occuranceCount);
        for(int i = 1; i < n1;i++){
            //if(occuranceCount[i])
            occuranceCount[i] = occuranceCount[i] + occuranceCount[i-1];
        }
        int i1 = 0;
        for(int i = 0; i < n2; i++){
            int currNum = arr2[i];
            int occurance = occuranceCount[currNum] - occuranceCount[currNum-1];
            System.out.println("Index : " + i1 + " CurrNum: "+ currNum + " occurance : " + occurance);
            int j = i1;
            while(j < i1+occurance){
                arr1[j] = currNum;
                j++;
            }
            i1 = j;
        }
        Utility.printArray(arr1);
        for(int i = n1-1; i >= n2; i--){
             int currNum = arr1[i];
             arr1[occuranceCount[currNum]-1] = currNum;
             occuranceCount[currNum] = occuranceCount[currNum] - 1;

        }

        return arr1;
        
    }



    public static void main(String[] args){

        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ans = relativeSortArray.relativeSortArray(arr1, arr2);
        Utility.printArray(ans);
        
    }
    
}
