package stunning.palm.tree.a;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public PartitionLabels(){}
	
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return new ArrayList<>();
        
        int[] map = new int[26];
        for(int i=0;i<S.length();i++){
            map[S.charAt(i)-'a'] = i;
        }
        
        int start = 0, last = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            last = Math.max(map[S.charAt(i)-'a'],last);
            if(last == i){
                res.add(last-start+1);
                start=i+1;
            }
        }
        
        return res;
    }
}
