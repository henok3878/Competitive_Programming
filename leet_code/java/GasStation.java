package leet_code.java;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
       
        int tgas = 0;
        int tcost=0;
       for (int i = 0; i < gas.length; i++) {
          tgas += gas[i];
          tcost += cost[i];
       }
       if(tgas >= tcost){
           int s = 0;
           int rg = 0;

           for (int i = 0; i < gas.length; i++) {
               rg = rg + gas[i] - cost[i];
               if(rg < 0){
                   s = i+1;
                   rg = 0;
               }
           }
         return s ;
       }else{
         return -1;
       }

      
      
  }
    
}
