package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCenterOfStarGraph {
	public FindCenterOfStarGraph() {}
	
    public int findCenter(int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] edge : edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.putIfAbsent(edge[1],new ArrayList<>());
        }
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }    
        
        int n = map.size();
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == n-1) return entry.getKey();
        }
        
        return -1;
    }
}
