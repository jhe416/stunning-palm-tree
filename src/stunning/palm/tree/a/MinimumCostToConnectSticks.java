package stunning.palm.tree.a;

import java.util.PriorityQueue;

/*
 * the idea of this question is basically always adding the smallest amout sticks together so the cost will always be the smallest
 * greedy
 * PriorityQueue is perfect is this case as it will auto sort the result for you and populate the smallest
 * Time O(nlog(n)) space O(n)
 */
public class MinimumCostToConnectSticks {
	public MinimumCostToConnectSticks() {}
	
    public int connectSticks(int[] sticks) {
        if(sticks == null || sticks.length < 2)return 0; 
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> (a-b));
        for(int i=0;i<sticks.length;i++){
            q.offer(sticks[i]);
        }
        int sum = 0;
        while(!q.isEmpty() && q.size() > 1){
            int cost = q.poll() + q.poll();
            sum+=cost;
            q.offer(cost);
        }
        
        return sum;
    }
}
