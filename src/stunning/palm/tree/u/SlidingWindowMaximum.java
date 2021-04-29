package stunning.palm.tree.u;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/*
 * the priority q always holds the max within the k range. 
 * once k range reaches priority queue flushes out anything outside the range to prepare for the next shift
 * Time O(nlogk)
 * Space constant
 */
public class SlidingWindowMaximum {
	public SlidingWindowMaximum() {}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        int i=0;
        int[] res = new int[nums.length-k+1];
        for(int j=0;j<nums.length;j++){
            q.offer(new int[]{nums[j],j});
              
            if(j-i==k-1){
               res[i] = q.peek()[0];
               while(!q.isEmpty() && q.peek()[1]<=i)q.poll();
               i++;
            }
        }
        
        return res;
    }
    
    //use stack ranks the current MAXs with last max being the maximum 
    //this is a great way of using stack that keeps track of ranking MAXs or MINs 
    //I have seen many questions now can be used with this approach
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i=0;
        int[] res = new int[nums.length-k+1];
        for(int j=0;j<nums.length;j++){
            while(!stack.isEmpty() && stack.peek()<nums[j])stack.pop();
            stack.push(nums[j]);
            if(j-i==k-1){
                res[i] = stack.peekLast();
                if(nums[i] == stack.peekLast()) stack.pollLast();
                i++;
            }
        }
        
        return res;
    }
}
