package leet_code.java;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int prev = 0;
        int next = 0;
        for(int i = 0; i < flowerbed.length; i++){
            prev = (i-1 < 0) ? i : i-1;
            next = (i + 1 >= flowerbed.length) ? i : i + 1;
            if(flowerbed[i] == 0 && flowerbed[prev] == 0 && flowerbed[next] == 0){
                count++;
                flowerbed[i] = 1;
            }   
        }
        return count >= n;
    }
    
}
