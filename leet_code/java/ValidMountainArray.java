package leet_code.java;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int pivot = 0;
        while(pivot < (arr.length-1) && arr[pivot] < arr[pivot + 1])
            pivot++;
        if((pivot + 1) == arr.length || pivot == 0) return false;
        while(pivot < (arr.length - 1) && arr[pivot] > arr[pivot + 1])
            pivot++;
        if((pivot + 1) == arr.length ) return true;
        
        return false;
        
    }
    
}
