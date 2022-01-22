package leet_code.java;

public class LongestRepeatingCharacterReplacement {
    
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int mostFreq = 0;
        int max = 0;
        int windowSt = 0;
        int[] counts = new int[26];
        
        for(int windowEnd = 0; windowEnd < len; windowEnd++){
            
            counts[s.charAt(windowEnd) - 'A']++;
            mostFreq = mostFreqElem(counts);
            if(((windowEnd - windowSt + 1) - mostFreq ) > k){
                // current window is invalid 
                counts[s.charAt(windowSt) - 'A']--;
                windowSt++;
            }else{
                // current window is valid 
                max = Math.max((windowEnd- windowSt + 1),max);
            }

        }
        
        return max;
        
    }
    
    private int mostFreqElem(int[] counts){
        int freq = 0;
        for(int count : counts){
            freq = Math.max(freq,count);
        }
        return freq;
    }



}
