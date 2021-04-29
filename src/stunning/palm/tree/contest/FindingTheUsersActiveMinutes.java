package stunning.palm.tree.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {
	public FindingTheUsersActiveMinutes() {}
	
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int[] res = new int[k];
        for(int[] log : logs){
            Set<Integer> times = map.getOrDefault(log[0],new HashSet<>());
            times.add(log[1]);
            map.putIfAbsent(log[0],times);
        }
        
        for(Map.Entry<Integer,Set<Integer>> entry : map.entrySet()){
            res[entry.getValue().size()-1]++;
        }
        
        return res;
    }
}
