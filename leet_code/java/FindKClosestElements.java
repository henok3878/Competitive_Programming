package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        // O(log(n))
        int mid = binarySearch(arr,x,0,n - 1);
        int left = (mid - k < 0) ? 0 : mid - k;
        int right = (mid + k >= n) ? n - 1 : mid + k;
        
        //O(k)
        while(right - left + 1 != k){
            if(Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) left++;
            else right--;
        }
        List<Integer> ans = new ArrayList();
        //O(k)
        for(int i = left; i <= right; i++) ans.add(arr[i]);
        
        return ans;
    }
    
    // O(log(n))
    private int binarySearch(int[] arr,int num, int st, int end){
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(arr[mid] > num) end = mid - 1;
            else if(arr[mid] < num) st = mid + 1;
            else return mid;
        }
        return st;
    }
}
