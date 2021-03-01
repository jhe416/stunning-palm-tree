package stunning.palm.tree.f;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeIntervals {
	public MergeIntervals() {}
	
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> ( b[0] - a[0]));
        
        for(int[] val : intervals){
            if(!q.isEmpty() && val[0] <= q.peek()[1]){
                if(val[1] > q.peek()[1])
                    q.offer(new int[]{q.poll()[0],val[1]});
            }else
                q.offer(val);
        }
        
        int[][] res = new int[q.size()][2];
        for(int i=0;i<res.length;i++){
            res[i] = q.poll();
        }
        
        return res;
    }
}
