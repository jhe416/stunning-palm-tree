package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * back tracking
 */
public class GrayCode {
	public GrayCode() {}
	
    public List<Integer> grayCode(int n) {
        if(n == 0) return new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        visited.add(0);res.add(0);
        helper(res,visited,n);
        return res;
    }
    
    private boolean helper(List<Integer> res, Set<Integer> visited, int n){
        if(res.size() == 1<<n) return true;
        int curr = res.get(res.size()-1);
        for(int i=0;i<n;i++){
            int next =curr ^ (1<<i);
            if(!visited.add(next)) continue;
            res.add(next);
            if(helper(res,visited,n)) return true;
            res.remove(res.size()-1);
            visited.remove(next);
        }
        
        return false;
    }
}
