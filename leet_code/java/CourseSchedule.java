package leet_code.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer,HashSet<Integer>> graph = new HashMap();
        for(int i = 0; i < numCourses; i++) graph.put(i, new HashSet());
        for(int[] edge : prerequisites) graph.get(edge[0]).add(edge[1]);
        Set<Integer> currPath = new HashSet();
        Set<Integer> visited = new HashSet();
        
        for(int node = 0;  node < numCourses; node++){
            if(hasCycle(graph,currPath,visited,node)) return false;
        }
        return true;
    }
    
    private boolean hasCycle(Map<Integer,HashSet<Integer>> graph, Set<Integer> currPath, Set<Integer> visited,int node){

        if(currPath.contains(node)) return true;
        
        currPath.add(node);
        for(int neigh : graph.get(node)){
            if(visited.contains(neigh)) continue;
            if(hasCycle(graph, currPath, visited, neigh)) return true;
        }
        visited.add(node);
        currPath.remove(node);

        return false;
    }
}
