package leet_code.java;

public class MinimumNonZeroProductOfTheArrayElements {
    static int MOD = 1000000007;
    public int minNonZeroProduct(int p) {         
        long max = (long)(Math.pow(2, p))-1;
        long secondMax = max - 1;
        long ans = ((pow(secondMax,max/2) % MOD)*(max%MOD))%MOD;
        return (int)ans;
    }
    
    
    private long pow(long x, long n){
        x %= MOD;
        if(n==0)return 1;
        if(n == 1) return x;
        long temp = pow(x,n/2) % MOD;
        temp = temp*temp%MOD;
        return n%2 == 0 ? temp : (x*temp)%MOD;
    }


    public static void main(String[] args){
        MinimumNonZeroProductOfTheArrayElements minimumNonZeroProductOfTheArrayElements = new MinimumNonZeroProductOfTheArrayElements();
        int p = 4;
        System.out.println("Ans for p = " + p + " : " +minimumNonZeroProductOfTheArrayElements.minNonZeroProduct(p));
    }
}
