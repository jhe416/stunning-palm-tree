package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.List;

/*
 * first build a directional graph and then dfs traverse.
 * 
 * Time O(n)
 * Space O(n)
 */
public class CourseScheduleII {
	public CourseScheduleII() {}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] val: prerequisites){
            graph.get(val[0]).add(val[1]);
        }

        int[] visit = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(visit[i] == 2) continue;
            if(!dfs(i,graph,visit,res)) return new int[0];
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean dfs(int n, List<List<Integer>> graph, int[] visit, List<Integer> res){
        if(visit[n] == 1){
            res = new ArrayList<>();
            return false;
        }
        if(visit[n] == 2) return true;
        
        visit[n] = 1;
        for(Integer node : graph.get(n)){
            if(!dfs(node,graph,visit,res)) return false;
        }
        visit[n] = 2;
        res.add(n);
        return true;
    }
}
