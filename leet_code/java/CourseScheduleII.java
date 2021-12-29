package leet_code.java;

public class CourseScheduleII {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for(int crs=0;crs<numCourses;crs++)
            map.put(crs, new HashSet());
        
        for(int[] p : prerequisites)
            map.get(p[0]).add(p[1]);
        
        boolean[] visited = new boolean[numCourses];
        boolean[] cycle = new boolean[numCourses];
        
        Stack<Integer> output = new Stack<>();
        
        for(int crs=0;crs<numCourses;crs++){
            if(!topoSort(crs, map, visited, cycle, output))
                return new int[]{};
        }
        
        int[] result = new int[numCourses];
        int idx = numCourses-1;
        while(!output.isEmpty())
            result[idx--] = output.pop();
        return result;
    }
    public boolean topoSort(int crs, HashMap<Integer, List<Integer>> map, boolean[] visited, boolean[] cycle,                   Stack<Integer> output){
        if(cycle[crs])  return false;
        if(visited[crs])    return true;
        cycle[crs] = true;
        for(int p : map.get(crs)){
            if(!topoSort(p, map, visited, cycle, output))
                return false;
        }
        cycle[crs] = false;
        visited[crs] = true;
        output.push(crs);
        return true;
    }


    public static void main(String[] args){
        
    }
    
}
