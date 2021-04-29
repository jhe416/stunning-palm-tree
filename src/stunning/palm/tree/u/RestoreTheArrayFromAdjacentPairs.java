package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {
	public RestoreTheArrayFromAdjacentPairs() {}
	
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length == 1) return adjacentPairs[0];
        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        for(int[] pair : adjacentPairs){
            graph.computeIfAbsent(pair[0], i -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], i -> new ArrayList<>()).add(pair[0]);
        }
        
        int start = 0;
        for(var entry : graph.entrySet()){
            if(entry.getValue().size() == 1){
                start = entry.getKey();
                break;
            }
        }
        
        int[] ans = new int[adjacentPairs.length+1];
        dfs(ans,graph,start,0);
        return ans;
    }
    
    private void dfs(int[] res, Map<Integer,List<Integer>> graph, int start, int index){
        res[index] = start;
        for(int next : graph.remove(start)){
            if(graph.get(next)==null) continue;
            dfs(res,graph,next,++index);
        }
    }
}
