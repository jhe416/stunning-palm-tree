package stunning.palm.tree.contest;

import java.util.Arrays;
//CheckIfArrayIsSortedAndRotated
public class CheckIfArrayIsSortedAndRotated {
	public CheckIfArrayIsSortedAndRotated() {}
	
    public boolean check(int[] nums) {        
        int[] tmp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        outer:
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j] != tmp[(j+i)%nums.length]) continue outer;
            }
            return true;
        }
        
        return false;
    }
}
