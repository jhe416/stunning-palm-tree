package stunning.palm.tree.a;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * classic stack problem, use stack to find out the first next greater value for example
 * 5436 -> 5,4,and 3 has a greater val of 6 store this result into a hashmap
 * later loop through nums1 see if its result is in the hashmap
 * if exists return the result otherwise return -1
 * Time O(n)
 * space O(n)
 */
public class NextGreaterElementI {
	public NextGreaterElementI() {}
	
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int j=0;j<nums2.length;j++){
            while(!stack.isEmpty() && stack.peek() < nums2[j]){
                map.put(stack.pop(),nums2[j]);
            }
                
            stack.push(nums2[j]);
        }
        for(int i=0;i<nums1.length;i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        
        return res;
    }
}
