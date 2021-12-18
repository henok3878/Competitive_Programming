package leet_code.java;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurance = new HashMap<Integer,Integer>();
        int[] ans = new int[k];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            int currNumOcc = occurance.getOrDefault(nums[i],0) + 1;
            occurance.put(nums[i],currNumOcc);
        }
        PriorityQueue<Entry> minHeap = new PriorityQueue<>((p1, p2) -> p1.freq - p2.freq);
        int i = 0;
        for (Map.Entry<Integer, Integer> itr : occurance.entrySet()) {
            int val = itr.getKey();
            int freq = itr.getValue();
            minHeap.add(new Entry(val, freq));
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        i = 0;
        while (k-- > 0) {
            ans[i++] = minHeap.remove().val;
        }
        return ans;
        
    }
    
    
    class Entry{
        int val;
        int freq;
        public Entry(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }

    public static void main(String[] args){
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
        
    }
    
}
