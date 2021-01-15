package stunning.palm.tree.f;

import java.util.HashMap;
import java.util.Map;

/*
 * Interesting question, finding the sums array and use two sum two solve
 * Time O(n)
 * Space constant
 */
public class SubarraySumEqualsK {
	
	public SubarraySumEqualsK() {}
	
	public int subarraySum(int[] nums, int k) {
		int[] sums = new int[nums.length+1];
		sums[0] = 0;

		for(int i=1;i<=nums.length;i++){
			sums[i] = sums[i-1] + nums[i-1];
		}

		//two sum
		int res = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<sums.length;i++){
			int comp = sums[i]-k;
			if(map.containsKey(comp)){
				res+=map.get(comp);
			}
			map.put(sums[i],map.getOrDefault(sums[i],0)+1);
		}

		return res;
	}
}
