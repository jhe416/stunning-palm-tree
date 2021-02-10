package stunning.palm.tree.f;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * basically largestRectangleArea
 */
public class MaximalRectangle {
	public MaximalRectangle() {}
	
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] map = new int[m][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[j][i] = matrix[j][i] == '0'? 0 : j>0? map[j-1][i] + 1 : 1;
            }
        }
        
        int max = 0;
        for(int i=0;i<m;i++){
            max = Math.max(max,largestRectangleArea(map[i]));
        }
        
        return max;
    }
    
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
