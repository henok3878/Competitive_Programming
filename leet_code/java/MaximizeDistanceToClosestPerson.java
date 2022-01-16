package leet_code.java;

public class MaximizeDistanceToClosestPerson {
    
    public int maxDistToClosest(int[] seats) {
        
        int[] maxAtI = new int[seats.length];
        maxAtI[0] = (seats[0] == 0) ? seats.length : 0;
        
        for(int i = 1; i < seats.length; i++){
            if(seats[i] == 0){
                maxAtI[i] = maxAtI[i-1] + 1;
            }
        }
        
        
        int max = maxAtI[seats.length - 1];
        
        for(int i = seats.length - 2; i >= 0;i--){
            if(seats[i] == 0){
                maxAtI[i] = Math.min(maxAtI[i+1] + 1,maxAtI[i]);
                max = Math.max(maxAtI[i],max);
            }
        }
                
        return max;
        
    }
    
}
