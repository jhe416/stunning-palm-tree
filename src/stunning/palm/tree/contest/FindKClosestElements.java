package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * this is a sort solution. basicaly define sort in the priority queue and do it
 * Time Onlogn)
 * space O(n)
 */
public class FindKClosestElements {
	public FindKClosestElements() {}
	
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> {
            if(Math.abs(a-x) < Math.abs(b-x)){
                return 1;
            }else if(Math.abs(a-x) == Math.abs(b-x)){
                if(a<b) return 1;
                else if(a>b) return -1;
                else return 0;
            }else{
                return -1;
            }
        });
        
        for(int val : arr){
            q.offer(val);
            if(q.size() > k) q.poll();
        }
        
        List<Integer> res = new ArrayList<>(q);
        Collections.sort(res);
        
        return res;
    }
}
