package hacker_rank;

public class CountingValleys {


    public static int countingValleys(int steps, String path) {
        int altitude = 0; // 0 represents sea Level, > 0 Mountains and < 0 Valleys 
        int numOfValleys = 0;
        for(int i = 0; i < steps ; i++){
            char currChar = path.charAt(i);
            if(currChar == 'D'){
                if(altitude == 0){
                    numOfValleys++;
                }
                altitude--;
            }
            else if(currChar == 'U'){
                altitude++;
            }


        }

        return numOfValleys; 
    }
    
}
