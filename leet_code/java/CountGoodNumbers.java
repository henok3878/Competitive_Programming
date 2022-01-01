package leet_code.java;

public class CountGoodNumbers {

    static long mod = 1000000007 ;
    
    public int countGoodNumbers(long n) {
        
        if(n==1){
            return 5;
        }
        
        long oddSlots = n/2;
        long evenSlots = n - oddSlots;

        return (int) ((pow( 5,evenSlots ) * pow( 4, oddSlots )) %mod ) ;
      
    }
    
    public long pow(long x , long n){
       
        if(n==0)
            return 1;    
        long temp = pow(x,n/2);
        temp *= temp;
        temp %= mod; 
        if(n % 2 == 0)
            return temp;
        else
            return (x * temp) % mod;
    }
    
    
}
