package leet_code.java;

public class H_Index {

    public int hIndex(int[] citations) {
        int[] count = new int[1001];
        
        for(int citation: citations){
            count[citation]++;
        }
        // create arr to hold num of papers with citation below a specific citation 
        int[] belowMe = new int[count.length];
        belowMe[0] = 0;
        for(int i = 1; i < belowMe.length;i++){
            belowMe[i] = belowMe[i-1]+ count[i-1];
        }
        
        for(int i = belowMe.length - 1; i >= 0; i--){
            if(citations.length - belowMe[i] >= i){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        H_Index h_Index = new H_Index();
        int[] citations = {3,0,6,1,5};
        //citations = [3,0,6,1,5]
        int result = h_Index.hIndex(citations);
        System.out.println("result: " + result);
    }   
    
}
