package leet_code.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarFleet {


    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList();
        for(int i = 0; i < position.length; i++){
            cars.add(new Car(position[i],speed[i]));
        }
       cars.sort((a,b)-> b.position - a.position);
        
        Stack<Car> stack = new Stack();
        Car firstCar= cars.get(0);
        stack.push(firstCar);
        double carInStackT = (double)(target - firstCar.position)/ firstCar.speed;
        for(int i = 1; i < cars.size(); i++){
            Car currentCar = cars.get(i);
            double currentCarT = (double)(target - currentCar.position)/currentCar.speed;
            if(currentCarT > carInStackT){
                stack.push(currentCar);
                carInStackT = currentCarT;
            }        
        }
        
        
        return stack.size();
        
    }
    
    class Car{
        int position;
        int speed; 
        Car(int pos, int speed){
            position = pos;
            this.speed = speed;
        }
    }    

    public static void main(String[] args){

        
    }
    
}
