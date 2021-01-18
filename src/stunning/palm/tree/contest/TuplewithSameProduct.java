package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * why times 8?
 * 2*1*2*1*2, 2 choose 2 times 2 choose 1 * (ohter side) 2*1 * 2 (swap side)
 * Time O(n^2)
 * Space O(n^2)
 */
public class TuplewithSameProduct {
	public TuplewithSameProduct() {}
	
    public int tupleSameProduct(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                list.add(nums[i]*nums[j]);
            }
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int val : list){
            if(map.containsKey(val))res+=(map.get(val)*8);
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        return res;
    }
}
