package stunning.palm.tree.u;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
	public MinimumAbsoluteDifference() {}
	
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        for(int i=1;i<nums.length;i++){
            min = Math.min(min,Math.abs(nums[i] - nums[i-1]));     
        }
        
        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[i-1]) == min){
                res.add(Arrays.asList(nums[i-1],nums[i]));
            }
        }
        return res;
    }
}
