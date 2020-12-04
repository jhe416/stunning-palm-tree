package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * build a graph then dfs Time O(n)
 * Space O(n)
 */
public class FriendCircles {
	public FriendCircles() {}
	
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int m = M.length;
        int n = M[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(M[i][j] == 1){
                    List<Integer> list1 = map.getOrDefault(i,new ArrayList<>());
                    List<Integer> list2 = map.getOrDefault(j,new ArrayList<>());
                    list1.add(j); list2.add(i);
                    map.putIfAbsent(i,list1); map.putIfAbsent(j,list2);
                }
            }
        }
        
        Set<Integer> visit = new HashSet<>(map.keySet());
        int res = 0;
        for(Integer person : map.keySet()){
            if(!visit.contains(person)) continue;
            if(visit.size() > 0) res++;
            dfs(person,map,visit);
        }
        
        return res;
    }
    
    private void dfs(int person, Map<Integer,List<Integer>> map,Set<Integer> visit){
        if(!visit.contains(person)) return;
        visit.remove(person);
        for(Integer friend : map.get(person)){
            if(friend == person) continue;
            dfs(friend,map,visit);
        }
    }
}
