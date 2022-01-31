package leet_code.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < n; i++) graph.put(i,new ArrayList<>());
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        return dfs(graph,source,destination,visited);
        
    }
    
    public boolean dfs(Map<Integer, List<Integer>> graph,int src, int dest, Set<Integer> visited){
        if(src == dest) return true;
        visited.add(src); // mark visited 
        for(int negh : graph.get(src)){
            if(visited.contains(negh)) continue; // if visited don't do dfs 
            if(dfs(graph,negh,dest, visited)) return true;
        }
        return false;
        
    }
}
