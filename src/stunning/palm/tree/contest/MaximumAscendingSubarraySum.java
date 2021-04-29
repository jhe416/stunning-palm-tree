package stunning.palm.tree.contest;

public class MaximumAscendingSubarraySum {
	public MaximumAscendingSubarraySum() {}
	
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] <= nums[i-1]){
                sum = nums[i];
            }else{
                sum+=nums[i];
            }
            
            res = Math.max(res,sum);
        }
        res = Math.max(res,sum);
        return res;
    }
}
