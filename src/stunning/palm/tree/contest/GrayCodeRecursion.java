package stunning.palm.tree.contest;

import java.util.ArrayList;
import java.util.List;

/*
 * ^ xor -> if there is 0 the bit remains the same
 * | bitwise or basically or
 * 1 << n meaning shift 1 to the left by n
 * T O(2^n) since we are going to loop all combination from 0 to n 
 * space O(n) as the recursion stack will increment to n stacks
 */
public class GrayCodeRecursion {
	public GrayCodeRecursion() {}
	
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        helper(res, n);
        return res;
    }
    
    private void helper(List<Integer> res, int n){
        if(n == 0){
            res.add(0);
            return;
        }
        
        helper(res, n-1);
        int size = res.size();
        int mask = 1<<(n-1);
        for(int i=size-1;i>=0;i--){
            res.add(res.get(i) | mask);
        }
    }
}
