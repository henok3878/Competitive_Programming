package leet_code.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> freqs = new HashMap();
        for(int i = 0; i < tasks.length; i++){
            freqs.put(tasks[i],freqs.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Task> tasksInPriority = new PriorityQueue(30,new TaskComparator());
        Queue<Task> tasksOnCoolDown = new LinkedList();
        for(char c : freqs.keySet()){
            tasksInPriority.add(new Task(freqs.get(c),0));
        }        
        int timeUnit = 1;
        while(!tasksInPriority.isEmpty() || !tasksOnCoolDown.isEmpty()){
            if(!tasksInPriority.isEmpty()){
                Task top = tasksInPriority.poll();   
                top.freq = top.freq - 1;
                if(top.freq > 0){
                    top.coolDown = timeUnit + n + 1;
                    tasksOnCoolDown.add(top);
                }
                timeUnit++;
                if(!tasksOnCoolDown.isEmpty()){
                    Task topInTheCoolDown = tasksOnCoolDown.peek();
                    if(topInTheCoolDown.coolDown == timeUnit){
                        tasksInPriority.add(topInTheCoolDown);
                        tasksOnCoolDown.remove();
                    }
                }
                       
            }else{
                Task topInTheCoolDown = tasksOnCoolDown.poll();
                timeUnit = topInTheCoolDown.coolDown;
                tasksInPriority.add(topInTheCoolDown);
                
            }

        }
        return timeUnit  - 1;
    }
    
    
    
    
     class TaskComparator implements Comparator<Task>{
         public int compare(Task a, Task b)
        {   
             return b.freq - a.freq;
        }
    }
    
    class Task{
        int freq;
        int coolDown;
        
        Task(int freq, int coolDown){
            this.freq = freq;
            this.coolDown = coolDown;
        }
        
        public String toString(){
            return "("+freq + ", " + coolDown+")";
        }
    }


    public static void main(String[] args){
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println("result: "+ result);
    }
    
}
