package stunning.palm.tree.a;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeIntervals {
	public MergeIntervals() {}
	
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) ->(b[1]-a[1]));
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        for(int[] interval : intervals){
            if(q.isEmpty()){
                q.offer(interval);
            }else{
                if(q.peek()[1]>=interval[0]){
                    q.offer(new int[]{q.peek()[0],Math.max(interval[1],q.poll()[1])});
                }else{
                    q.offer(interval);
                }
            }
        }
        
        int[][] res = new int[q.size()][2];
        for(int i=0;i<res.length;i++){
            res[i] = q.poll();
        }
        
        return res;
    }
}
