package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * find each bus and route, until the target route is found
 * Time O(nm) n as the total of number of buses and m being number of routes for each bus 
 * Space O(nm)
 */
public class BusRoutesBFS {
	public BusRoutesBFS() {}
	
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(target == source) return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int route : routes[i]){
                List<Integer> list = map.getOrDefault(route,new ArrayList<>());
                list.add(i);
                map.putIfAbsent(route,list);
            }
        }
        
        Queue<Integer> q = new LinkedList<>(map.get(source));
        Set<Integer> visitedBus = new HashSet<>(map.get(source));
        int res = 1;
        
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                int currBus = q.poll();

                for(int route : routes[currBus]){
                    if(route == target) return res;
                    for(int bus : map.get(route)){
                        if(!visitedBus.add(bus)) continue;
                        q.offer(bus);
                    }
                }
            }
            res++;
        }
        
        return -1;
    }
}
