package stunning.palm.tree.f;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOFFunctions {
	public ExclusiveTimeOFFunctions() {}
	
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs.size() < 2) return res;
        
        Deque<String[]> stack = new ArrayDeque<>();
        
        for(int i=1;i<logs.size();i++){
            String[] str1 = logs.get(i-1).split(":");
            String[] str2 = logs.get(i).split(":");
            Boolean isStart1 = str1[1].equals("start"), isStart2 = str2[1].equals("start");
            int time1 = Integer.valueOf(str1[2]), time2 = Integer.valueOf(str2[2]);
            int id1 = Integer.valueOf(str1[0]), id2 = Integer.valueOf(str2[0]);
            
            if(isStart1 && isStart2){
                res[id1]+=time2 - time1;
                stack.push(str1);
            }else if(isStart1 && !isStart2){
                res[id1] += time2 - time1 + 1;
            }else if(!isStart1 && isStart2){
                if(!stack.isEmpty())
                    res[Integer.valueOf(stack.peek()[0])] +=time2 - time1 - 1;
            }else{//!isStart! && !isStart2
                res[Integer.valueOf(stack.pop()[0])] += time2 - time1;
            }
        }
        
        return res;
    }
}
