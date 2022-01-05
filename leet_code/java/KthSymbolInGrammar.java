package leet_code.java;

public class KthSymbolInGrammar {
    
    public int kthGrammar(int n, int k) {
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
                nxtK = map(n,k);
            } 
            else{
                nxtK = map(n,k);
            }  
            return kthGrammar(n-1, nxtK);
                     
         }
     }
     
     private int map(int n, int k){
         int leng = (int)Math.pow(2,n-1);
         if(k <= leng/2){
             return k;
         }
         
         if(n % 2 == 0){
             if(k > leng/2 && k <= ((leng/2) + leng/4)){
                 return leng/4 + (k - leng/2);
             }else{
                 return k - (leng/2 + leng/4);
             }
         } 
         else{
             return  (leng/2 + 1) - (k - leng/2);
         }
     }
    
}
