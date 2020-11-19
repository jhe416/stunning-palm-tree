package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Tarjan's algorithm. using dfs, track the entry time and return the min entry time.
 * when a circle reaches to the end the entry time returned is always the first the entry time aka the min entry time
 * if the min entry time is greater than a node's entry time we know the node does not belong to the current cycle 
 * there for a connection is found.
 */
public class CriticalConnectionsInANetwork {
	public CriticalConnectionsInANetwork() {}
	
	int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if(connections == null || connections.size() == 0 || n == 0) return new ArrayList<>();
        
        //initialize graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        //build graph  
        for(List<Integer> connection : connections){
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        
        List<List<Integer>> res = new ArrayList<>();
        int[] visit = new int[n];
        int[] record = new int[n]; //this array is used to track the entry time for each node.
        
        for(int i=0; i<n; i++){
            if(visit[i] == 2) continue;//skip already visited node;
            dfs(i,-1,visit,record,res,graph);
        }
        return res;
    }
    
    private int dfs(int n, int parent, int[] visit, int[] record, List<List<Integer>> res, List<List<Integer>> graph){
        if(visit[n] == 1) return record[n];
        record[n] = ++time; visit[n]=1;
        int min_entry = Integer.MAX_VALUE;
        for(Integer node : graph.get(n)){
            if(node == parent || visit[node] == 2) continue;
            int entrytime = dfs(node,n,visit,record,res,graph);
            if(entrytime > record[n]){
                res.add(Arrays.asList(n,node));
            }
            
           min_entry = Math.min(entrytime,min_entry); 
        }
        visit[n] = 2;
        return min_entry;
    }
}
