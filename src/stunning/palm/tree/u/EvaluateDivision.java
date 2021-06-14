package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * this is a graph solution
 */
public class EvaluateDivision {
	public EvaluateDivision() {}

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Data>> map = new HashMap<>();
        int n = values.length;
        for(int i=0;i<n;i++){
            double value = values[i];
            List<String> eq = equations.get(i);
            map.computeIfAbsent(eq.get(0), k->(new ArrayList<>())).add(new Data(eq.get(1),value));
            map.computeIfAbsent(eq.get(1), k->(new ArrayList<>())).add(new Data(eq.get(0),1/value));
        } 
        
        double[] res = new double[queries.size()];
        Set<String> set = new HashSet<>();
        for(int i=0;i<res.length;i++){
            set.add(queries.get(i).get(0));
            res[i] = dfs(queries.get(i).get(0),queries.get(i).get(1),map, set);
            set.remove(queries.get(i).get(0));
        }
        return res;
    }
    
    private Double dfs(String s, String e, Map<String,List<Data>> map, Set<String> set){
        if(map.get(s) == null) return -1.0;
        if(s.equals(e)) return 1.0;
        
        for(Data next : map.get(s)){
            if(!set.add(next.node)) continue;
            double val = dfs(next.node,e,map,set);
            set.remove(next.node);
            if(val == -1.0) continue;
            return val * next.val;
        }
        
        return -1.0;
    }

	class Data{
		String node;
		Double val;

		public Data(String node, Double val){
			this.node = node;
			this.val = val;
		}
	}
}
