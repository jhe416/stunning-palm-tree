package stunning.palm.tree.contest;

import java.util.HashMap;
import java.util.Map;

/*
 * two sum with a little twist 
 */
public class CountNicePairsInAnArray {
	public CountNicePairsInAnArray() {}
	
    public int countNicePairs(int[] nums) {
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
        //nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        int mod = 1000000000+7;
        int[] revNums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            revNums[i] = reverse(nums[i]);
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int key = nums[i] - revNums[i];
            res = (res + map.getOrDefault(key,0))%mod;
            map.put(key,map.getOrDefault(key,0)+1);
        }
        
        return res;
    }
    
    public int reverse(int num){
        int res = 0;
        while(num>0){
            res = res*10 + num%10;
            num/=10;
        }
        return res;
    }
}
