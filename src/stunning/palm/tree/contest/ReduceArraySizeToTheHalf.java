package stunning.palm.tree.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {
	public ReduceArraySizeToTheHalf() {}
	
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        for(var entry : map.entrySet()){
            q.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int res = 0;
        int size = 0;
        while(!q.isEmpty() && size*2 < arr.length){
            size+=q.poll()[1];
            res++;
        }
        
        return res;
    }
}
