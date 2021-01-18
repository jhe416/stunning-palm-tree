package stunning.palm.tree.contest;

import java.util.Arrays;

/*
 * For each column, find the number of consecutive ones ending at each position.
 * For each row, sort the cumulative ones in non-increasing order and "fit" the largest submatrix.
 * Time O(mnlogn)
 * space constant
 */
public class LargestSubmatrixWithRearrangements {
	public LargestSubmatrixWithRearrangements() {}
	
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[j][i] = matrix[j][i] == 0? 0 : j>0? matrix[j-1][i] + 1 : 1;
            }
        }
        
        int res = 0;
        for(int i=0;i<m;i++){
            Arrays.sort(matrix[i]);
            for(int j=1;j<=n;j++){
                res = Math.max(res, j*(matrix[i][n-j]));
            }
        }
        
        return res;
    }
}
