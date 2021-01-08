package stunning.palm.tree.contest;

import java.util.PriorityQueue;

/*
 * use priority queue to sort the earliest expire apple and eat it first
 * Time O(nlog(n))
 * Space O(n)
 */
public class MaximumNumberOfEatenApples {
	public MaximumNumberOfEatenApples() {}
	
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
     
        int res = 0;
        int i=0;
        for(i=0;i<apples.length;i++){
            if(apples[i] > 0)
                q.offer(new int[]{apples[i],i+days[i]});
            
            while(!q.isEmpty() && (q.peek()[0] == 0 || q.peek()[1] <= i)) q.poll();
            if(q.isEmpty()) continue;
            q.peek()[0]--;
            res++;
        }
        
        while(!q.isEmpty()){           
            while(!q.isEmpty() && (q.peek()[0] == 0 || q.peek()[1] <= i)) q.poll();
            if(q.isEmpty()) continue;
            q.peek()[0]--;
            res++;
            i++;
        }
        
        return res;
    }
}
