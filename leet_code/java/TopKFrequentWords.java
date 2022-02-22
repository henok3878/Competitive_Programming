package leet_code.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> counts = new HashMap<>();
        for(String word : words){
            int freq = counts.getOrDefault(word,0) + 1;
            counts.put(word,freq);
        }
        
        Queue<Word> pq = new PriorityQueue<Word>((a,b)->(a.freq == b.freq) ? b.word.compareTo(a.word) : a.freq - b.freq);
        for(Map.Entry<String,Integer> entry : counts.entrySet()){
            String word = entry.getKey();
            int freq = entry.getValue();
            pq.add(new Word(word,freq));
        }
        
        while(pq.size() > k) pq.poll();
        
        String[] ans = new String[k];
        int idx = k - 1;
        while(!pq.isEmpty()){
            ans[idx] = pq.poll().word;
            idx--;
        }
        
        return Arrays.asList(ans);
        
        
    }

class Word {
    
    int freq;
    String word;
    public Word(String word, int freq){
        this.freq = freq;
        this.word = word;
    }
    
}
}
