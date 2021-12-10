package hacker_rank.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {


    public  void countSwaps(List<Integer> a) {
        int n = a.size();
        int numOfSwaps = 0;    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
            // Swap adjacent elements if they are in decreasing order
            int currentElem = a.get(j);
            int nextElem = a.get(j+1);
            if (currentElem > nextElem) {
                numOfSwaps++;
                a.set(j,nextElem);
                a.set(j+1, currentElem);
            }
        }
        }
        System.out.println("Array is sorted in " + numOfSwaps +" swaps.");
        System.out.println("First Element: "+a.get(0));
        System.out.println("Last Element: " + a.get(n-1));
        }


        public static void main(String[] args){
            List<Integer> a = Arrays.asList(3,2,1);
            BubbleSort bubbleSort = new BubbleSort();
            bubbleSort.countSwaps(a);


        }
    
}
