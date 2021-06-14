package stunning.palm.tree.u;
import java.util.*;

/*
 * https://www.youtube.com/watch?v=uJ8BAQ8lASE
 * Time O(n)
 * Space O(n)
 */
public class SplitArrayIntoConsecutiveSubsequences {
	public SplitArrayIntoConsecutiveSubsequences() {}
	
    public boolean isPossible(int[] nums) {
        if(nums.length < 3) return false;
        Map<Integer,Integer> fm = new HashMap<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int val : nums){
            fm.put(val,fm.getOrDefault(val,0)+1);
        }
        
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(fm.get(val) == 0) continue;
            if(hm.containsKey(val)){
                hm.put(val,hm.get(val)-1);
                if(hm.get(val) == 0){
                    hm.remove(val);
                }
                fm.put(val,fm.get(val)-1);
                hm.put(val+1,hm.getOrDefault(val+1,0)+1);
            }else{
                for(int j=0;j<3;j++){
                    if(fm.getOrDefault(val+j,0) == 0) return false;
                    fm.put(val+j,fm.get(val+j)-1);
                }
                hm.put(val+3,hm.getOrDefault(val+3,0)+1);
            }
        }
        
        return true;
    }
}
