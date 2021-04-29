package stunning.palm.tree.contest;

import java.util.HashSet;
import java.util.Set;
/*
 * find the max number then we know the gcd is in range of 1 .. max
 * now try all numbers from the gcd range 1..max increment by the multiple 
 * when a gcd is presented in the nums we find the gcd 
 * in the end the calculate gcd is equals to the original tried gcd meaning subsequence in the numbs can form a gcd of the tried
 * gcd so we increment the res
 * return the res as the final result.
 * link to this question:
 * https://www.youtube.com/watch?v=ptaC4X0hC2Q&ab_channel=%E5%AE%B0%E7%9B%B8%E5%B0%8F%E7%94%98%E7%BD%97
 * 
 * Time O(n^2)
 * space O(n)
 */
public class NumberOfDifferentSubsequencesGCDs {
	public NumberOfDifferentSubsequencesGCDs() {}
	
    Set<Integer> set = new HashSet<>();
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        
        boolean[] gcds = new boolean[max+1];
        for(int i=0;i<nums.length;i++){
            gcds[nums[i]] = true;
        }
        
        int res = 0;
        for(int i=1;i<=max;i++){
            int gcd = 0;
            for(int j=i;j<=max;j+=i){
                if(gcds[j]){
                    gcd = findGcd(gcd,j);
                }
            }
            if(gcd == i) res++;
        }
        
        return res;
    }
    
    private int findGcd(int a, int b){
        if(a == 0){
            return b;
        }
        
        return findGcd(b%a,a);
    }
}
