package stunning.palm.tree.f;

import java.util.HashMap;
import java.util.Map;

/*
 * should be an easy question, what we need to do is skip the 0s and calculate the dot product between the two
 * Time O(n)
 * space O(n)
 */
class SparseVector {
    public Map<Integer,Integer> map = new HashMap<>();
    SparseVector(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) continue;
            map.put(i,nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if(vec.map.size() == 0 || map.size() == 0) return 0;
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(vec.map.containsKey(entry.getKey())){
                res += (entry.getValue() * vec.map.get(entry.getKey()));
            }
        }
        
        return res;
    }
}
