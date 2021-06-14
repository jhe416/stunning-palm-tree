package stunning.palm.tree.contest;

public class MinimumDistanceToTheTargetElement {
	public MinimumDistanceToTheTargetElement() {}
	
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE; 
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                min = Math.min(Math.abs(i-start),min);
            }
        }
        
        return min;
    }
}
