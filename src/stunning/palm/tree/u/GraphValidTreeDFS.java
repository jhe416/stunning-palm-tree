package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTreeDFS {
	public GraphValidTreeDFS() {}
	
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) return true;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0],i->(new ArrayList<>())).add(edge[1]);
            graph.computeIfAbsent(edge[1],i->(new ArrayList<>())).add(edge[0]);
        }
        
        int[] visited = new int[n];
        if(dfs(visited,graph,0,-1)) return false;
        
        for(int val : visited)
            if(val != 2) return false;
        
        return true;
    }
    
    public boolean dfs(int[] visited, Map<Integer,List<Integer>> graph, int node, int p){
        if(visited[node] == 2) return false;
        if(graph.get(node) == null || visited[node] == 1) return true;
        visited[node] = 1;
        
        for(int next : graph.get(node)){
            if(next == p) continue;
            if(dfs(visited,graph,next,node)) return true;
        }
        visited[node] = 2;
        return false;
    }
}
