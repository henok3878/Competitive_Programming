package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        List<Integer> ranges = new ArrayList(n); 
        for(int i = 1; i <= n;i++){
            ranges.add(i);
        }
        int idx = 0;
        while(ranges.size() > 1){
            idx += (k  - 1);
            idx %= ranges.size();
            ranges.remove(idx);
        }
        return ranges.get(0);
    }


    public static void main(String[] args){
        FindTheWinnerOfTheCircularGame findTheWinnerOfTheCircularGame = new FindTheWinnerOfTheCircularGame();
        int res = findTheWinnerOfTheCircularGame.findTheWinner(6,5);
        System.out.println("Res: "+ res);
    }
}
