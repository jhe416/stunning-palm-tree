package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
	public CourseScheduleII() {}
	
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites){
            map.computeIfAbsent(p[0],i->(new ArrayList<>())).add(p[1]);
        }
        
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 2) continue;
            if(dfs(map,i,visited)) return new int[0];
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<ans.length;i++) ans[i] = res.get(i);
        return ans;
    }
    private boolean dfs(Map<Integer,List<Integer>> map, int node, int[] visited){
        if(visited[node] == 2) return false;
        if(visited[node] == 1) return true;
        visited[node] = 1;
        List<Integer> list = map.getOrDefault(node,new ArrayList<>());
        for(int next : list){
            if(dfs(map,next,visited))return true;
        }
        visited[node] = 2;
        res.add(node);
        return false;
    }
}
