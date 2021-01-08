package stunning.palm.tree.a;

import java.util.Arrays;

/*
 * compare a sorted version with the original to find out the starting index and end mismatch index
 * that is the array that needs to sort.
 * Time O(nlog(n))
 * space constant
 */
public class ShortestUnsortedContinuousSubarray {
	public ShortestUnsortedContinuousSubarray() {}
	
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = Arrays.copyOf(nums,nums.length);
        
        Arrays.sort(tmp);
        int start = -1;
        int end = -1;
        
        for(int i=0;i<nums.length;i++){
            if(tmp[i] != nums[i]){
                start = i;
                break;
            }
        }
        
        if(start == -1) return 0;
        
        for(int i=start+1;i<nums.length;i++){
            if(tmp[i] == nums[i] && end == -1){
                end = i;
            }else if(tmp[i] != nums[i]){
                end = -1;
            }
        }        
        
        if(end == -1) end = nums.length;
        return end - start;
    }
}
