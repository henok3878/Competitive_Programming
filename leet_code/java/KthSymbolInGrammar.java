package leet_code.java;

public class KthSymbolInGrammar {
    
    public int kthGrammar(int n, int k) {
        
        return helper(n,k);
    }
    
    private int helper(int n, int k){
        if(n == 1){
          return 0;
        }
        else if(n == 2){
            if(k == 1){
                return 0;
            }
            return 1;
        }
        else{
           int nxtK;
           if(n % 2 == 0){
               nxtK = mapEven(n,k);
           } 
           else{
               nxtK = mapOdd(n,k);
           }  
           return helper(n-1, nxtK);
                    
        }
    }
    int mapOdd(int n , int k){
        int leng = (int)Math.pow(2,n-1);
        if(k <= leng/2){
            return k;
        }
        else{
            return reverse(n,k);
        }
        
        
    }
    
    int mapEven(int n , int k){
        int leng = (int)Math.pow(2,n-1);
        if(k <= leng/2){
            return k;
        }
        else if(k > leng/2 && k <= ((leng/2) + leng/4)){
            return leng/4 + (k - leng/2);
        }else{
            return k - (leng/2 + leng/4);
        }
        
    }
    
    int reverse(int n, int k){
        int leng = (int)Math.pow(2,n-1);
        return (leng/2 + 1) - (k - leng/2);
    }
    
}
