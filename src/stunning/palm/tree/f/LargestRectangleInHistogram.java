package stunning.palm.tree.f;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * the stack use, is absolutely GOD LIKE!!!!!!!!!!!!!!!!!!
 * one solution solves four different cases:
 * 1. going down 
 * 2. going up,
 * 3. V shape, eg 2,1,2
 * 4. the left overs in the end
 * each index interval in the stack represents un-calculated valid area.
 * Time O(n)
 * Space O(n)
 */
public class LargestRectangleInHistogram {
	public LargestRectangleInHistogram() {}
	
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int i=0;
        for(i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                max = Math.max(max,heights[stack.pop()] * (i - (stack.isEmpty()? 0 : stack.peek() + 1)));
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
                max = Math.max(max,heights[stack.pop()] * (i - (stack.isEmpty()? 0 : stack.peek() + 1)));
        }
        
        return max;
    }
}
