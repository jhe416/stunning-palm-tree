package stunning.palm.tree.contest;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * pop when encounter a less order but making sure you have enough numbers to fill the stack
 * if not enough then just push
 * Time O(n)
 * Space O(n)	
 */
public class FindTheMostCompetitiveSubsequence {
	public FindTheMostCompetitiveSubsequence() {}

	public int[] mostCompetitive(int[] nums, int k) {
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i=0;i<nums.length;i++){
			if(!stack.isEmpty() && nums[i]<stack.peek()){
				while(!stack.isEmpty() && nums[i]<stack.peek() && nums.length - i -1 >= k-stack.size()){
					stack.pop();
				}
				stack.push(nums[i]);
			}else if(stack.size()<k){
				stack.push(nums[i]);
			}
		}

		int[] res = new int[stack.size()];
		for(int i=res.length-1;i>=0;i--){
			res[i]=stack.pop();
		}

		return res;
	}
}
