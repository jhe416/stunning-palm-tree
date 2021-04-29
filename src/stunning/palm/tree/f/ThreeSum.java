package stunning.palm.tree.f;

import java.util.*;

public class ThreeSum {
	public ThreeSum() {}
	
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int sum=nums[i], l=i+1, r=nums.length-1;
            while(l<r){
                if(nums[l] + nums[r] == -sum){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l+1<nums.length && nums[l] == nums[l+1])l++;
                    while(r>0 && nums[r] == nums[r-1])r--;
                    l++;r--;
                }else if(nums[l] + nums[r] > -sum ){
                    while(r>0 && nums[r] == nums[r-1])r--;
                    r--;
                }else{
                    while(l+1<nums.length && nums[l] == nums[l+1])l++;
                    l++;
                }
            }
        }
        
        return res;
    }
}
