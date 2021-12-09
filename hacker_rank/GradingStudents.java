package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingStudents {
    
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<Integer>();
        for(Integer grade : grades){
            if(grade < 38){
                roundedGrades.add(grade);
            }else{
                int nearestMultipleOfFive = (int)(Math.ceil(grade/5.0) * 5);
                if(nearestMultipleOfFive - grade < 3){
                    roundedGrades.add(nearestMultipleOfFive);
                }
                else{
                    roundedGrades.add(grade);
                }
                
            }  
        }
        return roundedGrades;
    }


    public static void main(String[] args){
        GradingStudents gradingStudents = new GradingStudents();
        List<Integer> roundedGrades = gradingStudents.gradingStudents(Arrays.asList(73,67,38,33));
        for(Integer grade : roundedGrades){
            System.out.print(grade + " , ");
        }
    }
}
