package leet_code.java.util;

public class Utility {


    public static void printArray(int[] arr){
        for(int elem : arr){
            System.out.print(elem+", ");
        }
        System.out.println();
    }

    public static String createStringFromArrayOfString(String[] arrOfStrings){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arrOfStrings.length; i++) {
            String suffix = " ";
            if(i==arrOfStrings.length - 1){
                suffix = "";
            }
            sb.append(arrOfStrings[i]+suffix);
        }
        String str = sb.toString();
        return str;
    }

    
}
