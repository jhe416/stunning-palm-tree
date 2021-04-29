package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * dijistra alg, from n finding shortest path to every node
 * then dp dfs find the restrict path
 * Time O(eloge) e being the edge, 
 * Space O(v+e)
 */
public class NumberOfRestrictedPathsFromFirstToLastNode {
	public NumberOfRestrictedPathsFromFirstToLastNode() {}
	
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        
        int[] dist = dijkstra(graph,n);
        
        return dfs(1,n,dist,graph, new Integer[n+1]);
    }
    
    private int dfs(int src, int n, int[] dist, List<List<int[]>> graph, Integer[] dp){
        if(dp[src] != null) return dp[src];
        if(src == n) return 1;
        
        int res = 0;
        for(int[] next : graph.get(src)){
            if(dist[src] > dist[next[0]]){
                res = (res + dfs(next[0],n,dist,graph,dp))%1000000007;
            }
        }
        
        return dp[src]=res;
    }
    
    private int[] dijkstra(List<List<int[]>> graph, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        q.offer(new int[]{n,0});
        
        while(!q.isEmpty()){
            int[] cnode = q.poll();
            int cv = cnode[0], cw = cnode[1];
            if(cw > dist[cv]) continue;
            for(int[] next : graph.get(cv)){
                int v = next[0],w=next[1];
                if(dist[cv] + w < dist[v]){
                    dist[v] = dist[cv]+w;
                    q.offer(new int[]{v,dist[v]});
                }
            }
        }
        
        return dist;
    }
}
