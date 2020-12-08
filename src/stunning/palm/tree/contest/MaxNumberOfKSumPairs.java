package stunning.palm.tree.contest;

import java.util.HashMap;
import java.util.Map;

/*
 * this is basically a two sum solution, only difference we keep the number of compliment indexes avaliable
 * in a map every time we found a comp we remove from the map
 * int the end the total pair is found
 * Time O(n)
 * Space O(n)
 */
public class MaxNumberOfKSumPairs {
	public MaxNumberOfKSumPairs() {}
	
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res =0;

        for(int i=0;i<nums.length;i++){
            int comp = k - nums[i];
            if(map.getOrDefault(comp, 0) > 0){
                map.put(comp,map.get(comp)-1);
                res++;
            }else
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return res;    
    }
}
