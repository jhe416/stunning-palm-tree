package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * this solution tle
 */
public class BusRoutesDFS {
	public BusRoutesDFS() {}
	
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int val : routes[i]){
                List<Integer> list = map.getOrDefault(val, new ArrayList<>());
                list.add(i);
                map.putIfAbsent(val,list);
            }
        }
        
        Map<Integer,Integer> cache = new HashMap<>(){{put(target,0);}};
       return helper(routes,map,source,target, cache, new HashSet<>()); 
    }
    
    private int helper(int[][] routes,  Map<Integer,List<Integer>> map, int source, int target, Map<Integer,Integer> cache, Set<Integer> visited){
        if(cache.get(source) != null) return cache.get(source);
        
        int res = -1;
        visited.add(source);
        for(int bus : map.get(source)){
            for(int route : routes[bus]){
                if(visited.contains(route)) continue;
                int val = helper(routes,map,route,target,cache,visited);
                if(val != -1){
                    res = res == -1? val + 1 : Math.min(res,val + 1);
                }
            }
        }
        visited.remove(source);
        cache.put(source,res);
        return res;
    }
}
