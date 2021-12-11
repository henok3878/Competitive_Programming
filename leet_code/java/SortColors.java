package leet_code.java;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] occurArray = new int[3];
        int[] outputArray = new int[nums.length];
        for(int i = 0; i < nums.length ; i++){
            int elem = nums[i];
            occurArray[elem] = occurArray[elem] + 1;
        }
        for(int i = 1; i < occurArray.length;i++){
            occurArray[i] = occurArray[i] + occurArray[i-1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            outputArray[occurArray[nums[i]] - 1] = nums[i];
            occurArray[nums[i]]--;
        }
        for(int i = 0; i < nums.length;i++){
            nums[i] = outputArray[i];
        }
    }

    public static void printArray(int[] arr){
        for(int elem : arr){
            System.out.print(elem+", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        SortColors sortColors = new SortColors();
        int[] arr = {2,0,2,1,1,0};
        sortColors.sortColors(arr);
        printArray(arr);
    }
    
}
