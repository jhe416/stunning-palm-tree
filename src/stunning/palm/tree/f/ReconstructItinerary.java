package stunning.palm.tree.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * greedy + dfs
 */
public class ReconstructItinerary {
	public ReconstructItinerary() {}
	
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            PriorityQueue<String> q = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            q.offer(ticket.get(1));
            map.putIfAbsent(ticket.get(0), q);
            map.putIfAbsent(ticket.get(1), new PriorityQueue<>());
        }
        List<String> res = new ArrayList<>();
        dfs(map,res,"JFK");
        
        return res;
    }
    
    private void dfs(Map<String,PriorityQueue<String>> map, List<String> res, String dept){
        PriorityQueue<String> q = map.get(dept);

        while(!q.isEmpty()){
            dfs(map,res,q.poll());
        }
        
        res.add(0,dept);
    }
}
