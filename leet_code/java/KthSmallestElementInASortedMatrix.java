package leet_code.java;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] oneD = new int[n*n];
        int idx = 0;
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                oneD[idx] = matrix[i][j];
                idx++;
            }
        }
        Arrays.sort(oneD);
        return oneD[k-1];        
        
    }
    
}
