package code_forces.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Twogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        Map<String,Integer> counts = new HashMap<>();
        String ans = "";
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n - 1;i ++){
            String sstr = s.substring(i,i + 2);
            int freq = counts.getOrDefault(sstr, 0) + 1;
            counts.put(sstr,freq);
            if(max <= freq){
                ans = sstr;
                max = freq;
            }
        }
       System.out.println(ans);
    }
}
