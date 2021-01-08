package stunning.palm.tree.contest;

import java.util.HashSet;
import java.util.Set;

/*
 * sliding window
 */
public class MaximumErasureValue {
	public MaximumErasureValue() {}
	
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int i=0;
        for(int j=0;j<nums.length;j++){
            while(!set.isEmpty() && set.contains(nums[j])){
                sum-=nums[i];
                set.remove(nums[i++]);
            }
            set.add(nums[j]);
            sum+=nums[j];
            res = Math.max(res,sum);
        }
        
        return res;
    }
}
