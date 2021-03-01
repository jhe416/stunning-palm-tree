package stunning.palm.tree.f;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII {
	public MaxConsecutiveOnesIII() {}
	
	/*
	 * sliding window the window stops expanding we k <0, only returns expand when k is greater than 0.
	 * k increments when a exchanged 0 is out of the window
	 * Time O(n)
	 * Space constant
	 * 
	 */
    public int longestOnes(int[] A, int K) {
        int left,right;
        for(left = 0,right=0;right < A.length;right++){
            if(A[right] == 0) K--;
            
            if(K<0){
                if(A[left] == 0) K++;
                left++;
            }
        }
        
        return right-left;
    }
    
    /*
     * sliding window using q to control expand and shrink.
     * Time O(n)
     * Space O(k)
     */
    public int longestOnesQueue(int[] nums, int K) {
        Queue<Integer> q = new LinkedList<>();
        int i=0;
        int res = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] == 0){
                if(!q.isEmpty() && q.size() == K){
                    i = q.poll()+1;
                    q.offer(j);
                }else if(K>0){
                    q.offer(j);
                }else{
                    i=j+1;
                }
            }
            
            res = Math.max(res,j-i+1);
        }
        
        return res;
    }
}
